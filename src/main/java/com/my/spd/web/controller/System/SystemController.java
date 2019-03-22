package com.my.spd.web.controller.System;


import com.my.spd.message.MessageModel;
import com.my.spd.message.loginmodle;
import com.my.spd.pojo.Menu;
import com.my.spd.pojo.Role;
import com.my.spd.pojo.User;
import com.my.spd.service.System.Impl.SystemServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by YangYuFan on 2019/2/1.
 */
@RestController
@Api(description = "公用方法接口")
public class SystemController {

    @Autowired
    private SystemServiceImpl systemService;


    @ApiOperation(value = "用户登入", httpMethod = "POST")
    @PostMapping("/login")
    public loginmodle login(@ApiParam(name = "user", value = "用户对象") @RequestBody User user, HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            token.setRememberMe(false); //设置记住我
            try {
                subject.login(token); //传入realm
            } catch (AuthenticationException e) {
                return loginmodle.fail(e.getMessage());
            }
        }
        //用户信息
        User currentUser = systemService.getUser();
        if (currentUser == null) {
            removeUser();
            return loginmodle.fail("用户出现异常");
        } else if(currentUser.getStatus() == 0){
            removeUser();
            return loginmodle.fail("该用户尚未激活");
        }
        //获取菜单
        List<List<Menu>> menuList = systemService.getCurrentUserMenuList();
        if (menuList == null) {
            removeUser();
            return loginmodle.fail("菜单出现异常");
        }
        //获取role对象
        List<Role> roleList = systemService.getCurrentUserRole();
        if (roleList == null) {
            removeUser();
            return loginmodle.fail("权限列表出现异常");
        }
        return loginmodle.success(currentUser, menuList, roleList); //成功
    }

    private MessageModel removeUser(){
        try {
            systemService.removeUser();
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            return null;
        } catch (Exception e) {
            return MessageModel.fail(e.getMessage());
        }
    }


    @ApiOperation(value = "用户登出", httpMethod = "GET")
    @GetMapping("/logout")
    public MessageModel logout() {
        MessageModel model = removeUser();
        if(model!=null){
            return model;
        }
        return MessageModel.success(null);
    }

    @ApiOperation(value = "获取所有角色权限", httpMethod = "GET")
    @GetMapping("/getRoleAll")
    public MessageModel getRoleAll() {
        return MessageModel.success(systemService.getRoleAll());
    }

    @ApiOperation(value = "权限异常", httpMethod = "GET")
    @GetMapping("/notPermission")
    public MessageModel notPermission() {
        return MessageModel.fail("您没有对应的权限");
    }

    @ApiOperation(value = "并非登入接口,当用户没有登入时,访问非暴露接口,便会访问该接口",httpMethod = "GET")
    @GetMapping("/login")
    public MessageModel login(){
        return MessageModel.fail("登入异常,请重新退出后登入");
    }

}
