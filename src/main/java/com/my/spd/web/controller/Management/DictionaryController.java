package com.my.spd.web.controller.Management;

import com.my.spd.message.MessageModel;
import com.my.spd.message.SO.Management.DictionarySo;
import com.my.spd.pojo.Dictionary;
import com.my.spd.service.Management.DictionaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by YangYuFan on 2019/2/27.
 */
@RestController
@RequestMapping("/management")
@Api(description = "字典接口")
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;


    @ApiOperation(value = "保存字典",httpMethod = "POST")
    @PostMapping("/saveDictionary")
    public MessageModel saveDictionary(@ApiParam(name = "dictionary",value = "字典表JSON对象") @RequestBody Dictionary dictionary){
        if(dictionary.getId()==null){
            if(1 == dictionaryService.addDictionary(dictionary));{
                return MessageModel.success(null,"保存成功");
            }
        }else{
            if(1 == dictionaryService.updateDictionary(dictionary));{
                return MessageModel.success(null,"保存成功");
            }
        }
    }


    @ApiOperation(value = "根据字典查询条件,查询字典列表",httpMethod = "POST")
    @PostMapping("/searchDictionary")
    public MessageModel searchDictionary(@ApiParam(name = "dictionary",value = "字典表查询条件JSON对象") @RequestBody DictionarySo dictionarySo){
        return MessageModel.success(dictionaryService.searchDictionary(dictionarySo));
    }

    @ApiOperation(value = "查询所有字典属性的类别列表",httpMethod = "GET")
    @GetMapping("/getAllCategory")
    public MessageModel getAllCategory(){
        return MessageModel.success(dictionaryService.getAllCategory());
    }

    @ApiOperation(value = "删除字典菜单根据主键",httpMethod = "GET")
    @GetMapping("/deleteDictionaryById/{id}")
    public MessageModel deleteDictionaryById(@ApiParam(name="id",value = "字典表主键") @PathVariable Integer id){
        if(1 == dictionaryService.deleteDictionaryById(id)){
            return MessageModel.success(null,"删除成功");
        }
        return MessageModel.fail("删除失败");
    }

    @ApiOperation(value = "导出所有字典数据至excel",httpMethod = "POST")
    @PostMapping("/exportDictionaryExcel")
    public MessageModel exportDictionaryExcel(HttpServletResponse response){
        Boolean excel = dictionaryService.exportDictionaryExcel(response);
        if(excel){
            return MessageModel.success(null,"导出成功");
        }
        return MessageModel.fail("导出失败");
    }

}
