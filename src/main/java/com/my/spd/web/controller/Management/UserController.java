package com.my.spd.web.controller.Management;

import com.my.spd.conf.baseConf.BaseConf;
import com.my.spd.message.MessageModel;
import com.my.spd.message.SO.Management.UserSo;
import com.my.spd.service.System.Impl.SystemServiceImpl;
import com.my.spd.service.System.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 杨宇帆
 * @create 2019-03-16
 */
@Controller
@RequestMapping("/management")
@Api(description = "用户接口")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SystemServiceImpl systemService;

    @Autowired
    private BaseConf baseConf;


    @ResponseBody
    @ApiOperation(value = "根据条件查询列表",httpMethod = "POST")
    @PostMapping("/searchUserList")
    public MessageModel searchUserList(@ApiParam(name="userSo",value = "用户查询条件")@RequestBody UserSo userSo){
        return MessageModel.success(userService.searchUserList(userSo));
    }

    @ResponseBody
    @ApiOperation(value = "发送手机验证码",httpMethod = "GET")
    @GetMapping("/sendMsg")
    public MessageModel sendMsg(){
        return MessageModel.success(userService.sendMsg(systemService.getUser().getPhone()));
    }

    @ResponseBody
    @ApiOperation(value = "保存用户",httpMethod = "POST")
    @PostMapping("/saveUser")
    public MessageModel saveUser(@ApiParam(name="userSo",value = "用户与权限保存参数") @RequestBody UserSo userSo){
        if(userSo.getId() == null || userSo.getId()==0){
            //新增
            if(!userService.saveUser(userSo))
                MessageModel.fail("账号已被占用");
            return MessageModel.success(null,"已经向新用户发送了一封邮件,请根据邮件激活账号");
        }else{
            if(!userService.updateUser(userSo))
                MessageModel.fail("更新用户失败");
            return MessageModel.success(null,"更新用户成功");
        }
    }


    @ApiOperation(value = "激活用户并跳转地址",httpMethod = "GET")
    @GetMapping("/activateUser/{id}")
    public void activateUser(HttpServletResponse response, @ApiParam(name = "id",value = "用户主键") @PathVariable Integer id) throws IOException {
        userService.ActivateUser(id);
        response.sendRedirect(baseConf.getVueAddress());
    }

    @ApiOperation(value = "删除用户",httpMethod = "GET")
    @ResponseBody
    @GetMapping("/deleteUserById/{id}")
    public MessageModel deleteUserById(@ApiParam(name = "id",value = "用户主键") @PathVariable Integer id){
        if(!userService.deleteUserById(id))
            return MessageModel.fail("删除用户异常");
        return MessageModel.success(null,"删除用户成功");
    }

}
