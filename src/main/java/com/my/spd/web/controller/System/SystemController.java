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



    @ApiOperation(value = "用户登入",httpMethod = "POST")
    @PostMapping("/login")
    public loginmodle login(@ApiParam(name = "user",value = "用户对象") @RequestBody User user, HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        if(!subject.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
            token.setRememberMe(true); //设置记住我
            try {
                subject.login(token); //传入realm
            }catch (AuthenticationException e){
                return loginmodle.fail(e.getMessage());
            }
        }
        //用户信息
        User currentUser = systemService.getUser();
        if(currentUser == null){
            return loginmodle.fail("用户出现异常");
        }
        //获取菜单
        List<List<Menu>> menuList = systemService.getCurrentUserMenuList();
        if(menuList == null){
            return loginmodle.fail("菜单出现异常");
        }
        //获取role对象
        List<Role> roleList =  systemService.getCurrentUserRole();
        if(roleList == null){
            return loginmodle.fail("权限列表出现异常");
        }
        return loginmodle.success(currentUser,menuList,roleList); //成功
    }

    @ApiOperation(value = "用户登出",httpMethod = "GET")
    @GetMapping("/logout")
    public MessageModel logout(){
        try {
            systemService.removeUser();
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
        }catch (Exception e){
            return MessageModel.fail(e.getMessage());
        }
        return MessageModel.success(null);
    }

    @ApiOperation(value = "获取所有角色权限",httpMethod = "GET")
    @GetMapping("/getRoleAll")
    public MessageModel getRoleAll(){
        return MessageModel.success(systemService.getRoleAll());
    }

    @ApiOperation(value = "权限异常",httpMethod = "GET")
    @GetMapping("/notPermission")
    public MessageModel notPermission(){
        return MessageModel.fail("您没有对应的权限");
    }

}
