package com.my.spd.web.controller.MainRoom;

import com.my.spd.message.MessageModel;
import com.my.spd.message.SO.MainRoom.TransmissionSo;
import com.my.spd.service.MainRoom.TransmissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author 杨宇帆
 * @create 2019-04-13
 */
@Api(description = "订单运输单接口")
@RequestMapping("/mainroom")
@RestController
public class TransmissionController {
    @Autowired
    private TransmissionService transmissionService;


    @ApiOperation(value = "保存请求单",httpMethod = "POST")
    @PostMapping("/saveRequestForm")
    public MessageModel saveRequestForm(@ApiParam(name="transmissionSoList",value = "请求单集合Json对象") @RequestBody TransmissionSo[] transmissionSoList){
        List<TransmissionSo> transmissionSos = Arrays.asList(transmissionSoList);
        if(CollectionUtils.isEmpty(transmissionSos))
            return MessageModel.fail("不能保存空订单");
        return transmissionService.saveRequestForm(transmissionSos);
    }


}
