package com.my.spd.service.System.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.spd.conf.baseConf.BaseConf;
import com.my.spd.dao.HospitalMapper;
import com.my.spd.dao.RoleMapper;
import com.my.spd.dao.UserMapper;
import com.my.spd.message.SO.Management.UserSo;
import com.my.spd.pojo.Hospital;
import com.my.spd.pojo.User;
import com.my.spd.pojo.UserExample;
import com.my.spd.pojo.User_Role;
import com.my.spd.service.System.UserService;
import com.my.spd.utils.Send.MessageSend;
import com.my.spd.utils.md5.UserPasswordCheck;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by YangYuFan on 2019/2/1.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MessageSend messageSend;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private BaseConf baseConf;

    @Autowired
    private HospitalMapper hospitalMapper;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User getUserOnLogin(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(example);
        if(users.size()==0||users.get(0)==null){
            return null;
        }
        return users.get(0);
    }

    @Override
    public PageInfo<User> searchUserList(UserSo userSo) {
        PageHelper.startPage(userSo.getPageNum(), userSo.getPageSize());
        List<User> list = userMapper.searchUserList(userSo);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public String sendMsg(String phone) {
        //生成随机4为数字验证码
        String random = Integer.toString(RandomUtils.nextInt(1000, 9999));
        logger.info("手机号为:"+phone+"发送一条短信,随机码为:"+random);
        //发送验证码
//        messageSend.sendSMS(phone, random);
        return random;
    }

    @Transactional
    @Override
    public Boolean saveUser(UserSo userSo) {
        //检查
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(userSo.getUsername());
        long count = userMapper.countByExample(userExample);
        if(count>0){
            return false;
        }
        //bean复制
        User user = new User();
        BeanUtils.copyProperties(userSo, user);
        //盐,以用户账号进行加盐
        SimpleHash md5 = new UserPasswordCheck().check(userSo.getUsername(), userSo.getPassword());
        user.setPassword(md5.toString());
        //其他数据封装
        user.setRegistertime(new Date());
        user.setStatus(0);
        //保存
        userMapper.insertShowID(user);
        List<Integer> roles = userSo.getRoles();
        //保存用户权限
        roles.forEach(i->{
            User_Role userRole = new User_Role();
            userRole.setRoleid(i);
            userRole.setUserid(user.getId());
            userMapper.insertUserAndRole(userRole);
        });

        //医院人数加1
        ChangeHospitalUserCount(userSo.getHospitalid(),1);

        //发送邮件
        String href = baseConf.getJavaAddress()+"/management/activateUser/"+user.getId();
        String path = "<span>您好,亲爱的"+user.getName()+",欢迎使用本SPD产品,请点击链接前往激活账号:"+href+"</span>";
        logger.info(path);
        //拼装地址
        messageSend.sendMail(user.getEmail(), path);
        return true;
    }

    @Async
    public synchronized void ChangeHospitalUserCount(Integer hospitalid,Integer index){
        Hospital hospital = hospitalMapper.selectByPrimaryKey(hospitalid);
        hospital.setEmployeecount(hospital.getEmployeecount()+index);
        hospitalMapper.updateByPrimaryKey(hospital);
    }


    @Override
    public void ActivateUser(Integer id) {

        User user = new User();
        user.setId(id);
        user.setStatus(1);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Transactional
    @Override
    public Boolean deleteUserById(Integer id) {
        //查找用户
        User user = userMapper.selectByPrimaryKey(id);
        //删除
        int i = userMapper.deleteByPrimaryKey(id);
        int x = userMapper.deleteUserRoleById(id);
        ChangeHospitalUserCount(user.getHospitalid(),-1);
        if(i==1&&x>0)
            return true;
        return false;
    }

    @Override
    public boolean updateUser(UserSo userSo) {
        User user = new User();
        BeanUtils.copyProperties(userSo, user);
        //判断用户是否需要修改密码
        if(StringUtils.isNotBlank(user.getPassword())){
            user.setPassword(new UserPasswordCheck().check(user.getUsername(), user.getPassword()).toString());
        }
        int i = userMapper.updateByPrimaryKeySelective(user);
        if(i==1)
            return true;
        return false;
    }
}
