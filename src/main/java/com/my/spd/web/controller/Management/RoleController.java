package com.my.spd.web.controller.Management;

import com.my.spd.message.MessageModel;
import com.my.spd.service.Management.RoleService;
import com.my.spd.service.System.Impl.SystemServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by YangYuFan on 2019/2/28.
 */
@RestController
@RequestMapping("/management")
@Api(description = "权限用户接口")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private SystemServiceImpl systemService;


    @ApiOperation(value = "展示权限用户列表",httpMethod = "GET")
    @GetMapping("/showRoles")
    public MessageModel showRoles(){
        return MessageModel.success(roleService.showRoles());
    }

    @ApiOperation(value = "保存用户权限",httpMethod = "GET")
    @GetMapping("/saveRole")
    public MessageModel saveRole(
        @ApiParam(name = "oldName",value = "旧权限名")  String oldName,
        @ApiParam(name = "newName",value = "新权限名")  String newName
    ){
        if(oldName == null|| StringUtils.isBlank(oldName)||oldName.equals("null")){
            //添加
           if(!roleService.addRole(newName)){
               MessageModel.fail("已有该权限名");
           }
        }else{
            //修改
            if(!roleService.updateRole(oldName,newName)){
                MessageModel.fail("更新失败");
            }
        }
        //去除缓存
        systemService.clearRoleCache();
        return MessageModel.success(null,"保存成功");
    }
}
