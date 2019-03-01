package com.my.spd.service.System.Impl;

import com.my.spd.dao.MenuMapper;
import com.my.spd.dao.RoleMapper;
import com.my.spd.dao.UserMapper;
import com.my.spd.pojo.*;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


/**
 * Created by YangYuFan on 2019/2/1.
 */
@Service
public class SystemServiceImpl {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RoleMapper roleMapper;


    public User getUser(){
        Object user = SecurityUtils.getSubject().getSession().getAttribute("user");
        if(user==null){
            logger.error("报错啦---------------------------------没有用户------------------------------------------");
            return null;
        }else {
            return (User)user;
        }
    }

    public void removeUser(){
        if(SecurityUtils.getSubject().getSession().getAttribute("user")!=null) {
            //删除redis中该用户的缓存
            HashOperations ops = redisTemplate.opsForHash();
            redisTemplate.expire(getUser().getId(),0L,TimeUnit.SECONDS);

            //要先删除redis中的,再删除session中的

            //删除用户,最后操作
            SecurityUtils.getSubject().getSession().removeAttribute("user");

        }else{
            if(logger.isDebugEnabled()){
                logger.debug("没有用户");
            }
        }
    }
    /**
     * 排序规则
     * 选项节点必定为100的倍数，从100开始顺序
     * 他的下级节点必定为10的倍数,从100开始降序
     * */
    public List<List<Menu>> getCurrentUserMenuList() {
        HashOperations ops = redisTemplate.opsForHash();
        List<List<Menu>> menu = (List<List<Menu>>)ops.get(getUser().getId(),"menu");
        //重新设置过期时间
        redisTemplate.expire(getUser().getId(),30L,TimeUnit.MINUTES);
        if(menu==null){
            //获取用户role权限集合
            User user = getUser();
            if(user!=null){
                List<Integer> roleList = getCurrentUserRole().stream().map(i -> i.getId()).collect(Collectors.toList());
                //根据Role权限进行菜单选择
                if(roleList!=null){
                    MenuExample example = new MenuExample();
                    //in
                    example.createCriteria().andRoleidIn(roleList).andIsshowEqualTo("1");
                    //order by
                    example.setOrderByClause("`sort` DESC");
                    List<Menu> menus = menuMapper.selectByExample(example);
                    if(menus.size()>0&&menus!=null){
                        //根据第一个,最大的sort来确定数组大小
//                    List<Menu>[] menuList = new List[menus.get(0).getSort()/100];
                        List<List<Menu>> menuList = new ArrayList<List<Menu>>();
                        for (int i = 0; i <menus.get(0).getSort()/100 ; i++) {
                            menuList.add(new ArrayList<Menu>());
                        }
                        for (Menu list : menus) {
                            int i = ((int) Math.ceil(list.getSort() / 100.0)) - 1;
                            menuList.get(i).add(list);
                        }
//                    ArrayList<List<Menu>> lists = new ArrayList<>(Arrays.asList(menuList));
                        menuList.forEach(i->{
                            Collections.sort(i, new Comparator<Menu>() {
                                @Override
                                public int compare(Menu o1, Menu o2) {
                                    return o2.getSort()-o1.getSort();
                                }
                            });
                        });
                        //添加缓存
                        ops.put(getUser().getId(),"menu",menuList);
                        redisTemplate.expire(getUser().getId(),30L,TimeUnit.MINUTES);
                        return menuList;
                    }else{
                        if(logger.isDebugEnabled()){
                            logger.error(user.getId()+":"+user.getUsername()+"!出现无菜单情况");
                        }
                        return null;
                    }
                }else{
                    if(logger.isDebugEnabled()){
                        logger.error(user.getId()+":"+user.getUsername()+"!出现该用户权限无菜单情况");
                    }
                    return null;
                }
            }else{
                return null;
            }
        }
        return  menu;
    }

    public List<Role> getCurrentUserRole() {
        HashOperations ops = redisTemplate.opsForHash();
        List<Role> role = (List<Role>)ops.get(getUser().getId(),"role");
        redisTemplate.expire(getUser().getId(),30L,TimeUnit.MINUTES);
        if(role==null){
            User user = getUser();
            if(user!=null){
                //获得自己权限role的list
                List<Integer> roleList = userMapper.selectasRoleList(user.getId());
                if(roleList!=null){
                    RoleExample example = new RoleExample();
                    example.createCriteria().andIdIn(roleList);
                    example.setOrderByClause(" `id` asc");
                    List<Role> roles = roleMapper.selectByExample(example);
                    ops.put(getUser().getId(),"role",roles);
                    redisTemplate.expire(getUser().getId(),30L,TimeUnit.MINUTES);
                    return roles;
                }else{
                    if(logger.isDebugEnabled()){
                        logger.error("该用户:"+user.getUsername()+"无任何权限");
                    }
                    return null;
                }
            }else{
                return null;
            }
        }
        return role;
    }

    //获得所有权限属性
    public List<Role> getRoleAll() {
        ValueOperations ops = redisTemplate.opsForValue();
        List<Role> roles = (List<Role>)ops.get("roles");
        if(roles==null){
            List<Role> roleList = roleMapper.selectByExample(new RoleExample());
            //加入缓存
            ops.set("roles",roleList);
            return roleList;
        }
        return roles;
    }
    //去除权限缓存
    public void clearRoleCache(){
        redisTemplate.expire("roles",0,TimeUnit.MINUTES);
    }
}
