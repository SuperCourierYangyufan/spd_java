package com.my.spd.service.System.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.spd.dao.UserMapper;
import com.my.spd.message.SO.Management.UserSo;
import com.my.spd.pojo.User;
import com.my.spd.pojo.UserExample;
import com.my.spd.service.System.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YangYuFan on 2019/2/1.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

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
}
