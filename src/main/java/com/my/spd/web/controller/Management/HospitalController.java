package com.my.spd.web.controller.Management;

import com.my.spd.message.MessageModel;
import com.my.spd.message.SO.Management.HospitalSo;
import com.my.spd.pojo.Hospital;
import com.my.spd.service.Management.HospitalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 杨宇帆
 * @create 2019-03-11
 */
@RestController
@RequestMapping("/management")
@Api(description = "医院资料接口")
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    @ApiOperation(value = "保存医院",httpMethod = "POST")
    @PostMapping("/saveHospital")
    public MessageModel saveHospital(@RequestBody Hospital hospital){
        if(hospital.getId() == null){
            if(hospitalService.addHospital(hospital))
                return MessageModel.success(null, "保存成功");
        }else{
            if(hospitalService.updatehospital(hospital))
                return MessageModel.success(null, "保存成功");
        }
        return MessageModel.fail("保存失败");
    }

    @ApiOperation(value = "根据医院查询条件,查询医院列表",httpMethod = "POST")
    @PostMapping("/searchHospital")
    public MessageModel searchDictionary(@ApiParam(name = "hospitalSo",value = "医院表查询条件JSON对象") @RequestBody HospitalSo hospitalSo){
        return MessageModel.success(hospitalService.searchHospital(hospitalSo));
    }

    @ApiOperation(value = "根据id删除医院" ,httpMethod = "GET")
    @GetMapping("/deleteHospital/{id}")
    public MessageModel deleteHospital(@ApiParam(name="id",value = "主键") @PathVariable Integer id){
        if(hospitalService.deleteHospital(id)==1){
            return MessageModel.success(null,"删除成功");
        }
        return MessageModel.fail("删除异常");
    }

    @ApiOperation(value = "查询所有医院的名字和id")
    @GetMapping("/searchHospitalIdAndName")
    public MessageModel searchHospitalIdAndName(){
        return MessageModel.success(hospitalService.searchHospitalIdAndName());
    }
}
