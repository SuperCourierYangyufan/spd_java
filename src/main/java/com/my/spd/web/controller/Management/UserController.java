package com.my.spd.web.controller.Management;

import com.my.spd.message.MessageModel;
import com.my.spd.message.SO.Management.UserSo;
import com.my.spd.service.System.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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


    @ApiOperation(value = "根据条件查询列表",httpMethod = "POST")
    @PostMapping("/searchUserList")
    public MessageModel searchUserList(@ApiParam(name="userSo",value = "用户查询条件")@RequestBody UserSo userSo){
        return MessageModel.success(userService.searchUserList(userSo));
    }


}
