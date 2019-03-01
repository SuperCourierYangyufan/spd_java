package com.my.spd.web.controller.Management;

import com.my.spd.message.MessageModel;
import com.my.spd.conf.baseConf.BaseConf;
import com.my.spd.message.SO.Management.MenuSo;
import com.my.spd.pojo.Menu;
import com.my.spd.service.Management.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by YangYuFan on 2019/2/23.
 */
@RestController
@RequestMapping("/management")
@Api(description = "菜单列表接口")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @Autowired
    private BaseConf baseConf;


    @ApiOperation(value = "根据条件查询菜单列表分页",httpMethod = "POST")
    @PostMapping(value = "/searchMenu")
    public MessageModel searchMenu(@ApiParam(name = "menu",value = "菜单查询条件") @RequestBody MenuSo menu){
        return MessageModel.success(menuService.searchMenu(menu));
    }



    @ApiOperation(value = "查询所有父节点信息",httpMethod = "GET")
    @GetMapping(value = "/searchRootMenu")
    public MessageModel searchRootMenu(){
        return MessageModel.success(menuService.searchRootMenu());
    }

    @ApiOperation(value = "保存菜单信息",httpMethod = "POST")
    @PostMapping(value = "/saveMenu")
    public MessageModel saveMenu(@ApiParam(name = "menu",value = "菜单实体对象")@RequestBody Menu menu){
        String message = "";
        if(menu.getId()==null){
            message = menuService.addMenu(menu);

        }else{
            message = menuService.updateMenu(menu);
        }
        if(message.equals(baseConf.getSuccessCode())){
            return MessageModel.success(null,"保存成功");
        }

        return MessageModel.fail("保存数据异常");
    }

    @ApiOperation(value = "根据Id删除菜单",httpMethod = "GET")
    @GetMapping("/deleteMenuById/{id}")
    public MessageModel deleteMenuById(@ApiParam(name = "id",value = "菜单主键") @PathVariable Integer id){
        int deleteCount = menuService.deleteMenuById(id);
        if(deleteCount>0){
            return MessageModel.success(null,"删除成功");
        }
        return MessageModel.fail("删除数据异常");
    }

}
