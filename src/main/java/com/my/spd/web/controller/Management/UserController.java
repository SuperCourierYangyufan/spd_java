package com.my.spd.web.controller.Management;

import com.my.spd.service.System.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨宇帆
 * @create 2019-03-16
 */
@RestController
@RequestMapping("/management")
@Api(description = "用户接口")
public class UserController {
    @Autowired
    private UserService userService;



}