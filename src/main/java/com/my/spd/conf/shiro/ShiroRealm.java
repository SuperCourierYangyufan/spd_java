package com.my.spd.conf.shiro;

import com.my.spd.pojo.Role;
import com.my.spd.pojo.User;
import com.my.spd.service.System.Impl.SystemServiceImpl;
import com.my.spd.service.System.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private SystemServiceImpl systemService;

    @Override //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) {
        //将其转化为UsernamePassWordToken
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        //获得账号密码
        String username = token.getUsername();
        String password = new String(token.getPassword());
        //从数据库中获取数据
        User user = userService.getUserOnLogin(username);
        //根据需求判断,抛出异常,可自定义
        if(user==null){
            throw new UnknownAccountException("用户账号不存在");
        }
        //盐,以用户账号进行加盐
        ByteSource byteSource = ByteSource.Util.bytes(username);
        SimpleHash md5 = new SimpleHash("MD5", password, byteSource, 1);
        if(md5==null||!user.getPassword().equals(md5.toString())){
            throw new UnknownAccountException("密码不正确");
        }
        //存入session
        SecurityUtils.getSubject().getSession().setAttribute("user",user); //存入用户至session

        String realmName = getName(); //当前realm的名字
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),byteSource,realmName);
        return info;
    }

    @Override //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //从中获取登录用户的信息
        User principal = (User) principalCollection.getPrimaryPrincipal(); //获得用户名,或者是用户实体类
        //利用登入的用户信息来对当前用户角色进行授权
        Set<String> roles = new HashSet<>(); //权限列表
        Iterator<String> iterator = roles.iterator();
        //从数据库获得权限级别
        List<Role> list = systemService.getCurrentUserRole();
        //药房给药库权限
        for(Role i :list){
            if(i.getId().equals(3)){
                i.setId(2);
                break;
            }
        }
        //添加权限
        list.forEach(i->roles.add("role"+i.getId()));
        //创建SimpleAuthorizationInfo,添加权限列表进去
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
        return info;
    }
}