package com.my.spd.web.controller.MainRoom;

import com.github.pagehelper.PageInfo;
import com.my.spd.message.MessageModel;
import com.my.spd.message.SO.MainRoom.OrderDetailsSo;
import com.my.spd.message.SO.MainRoom.OrderSo;
import com.my.spd.message.VO.OrderDetailsVO;
import com.my.spd.pojo.OrderMain;
import com.my.spd.service.MainRoom.OrderService;
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
 * @create 2019-03-30
 */
@Api(description = "订单接口")
@RestController
@RequestMapping("/mainroom")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @ApiOperation(value = "显示当前用户该权限组的订单",httpMethod = "POST")
    @PostMapping("/searchOrders")
    public MessageModel searchOrders(@ApiParam(name = "orderSo" , value = "订单查询参数JSON") @RequestBody OrderSo orderSo){
        PageInfo<OrderMain> pageInfo = orderService.searchOrders(orderSo);
        if(null == pageInfo)
            return MessageModel.fail("查询出现异常");
        return MessageModel.success(pageInfo);
    }

    @ApiOperation(value="查询子订单",httpMethod = "POST")
    @PostMapping("/showItem")
    public MessageModel showItem(@ApiParam(name = "orderSo" , value = "订单查询参数JSON")@RequestBody OrderSo orderSo){
        PageInfo<OrderDetailsVO> details = orderService.showItem(orderSo);
        if(null==details)
            return  MessageModel.fail("查询出现异常");
        return MessageModel.success(details);
    }


    @ApiOperation(value = "更新实收数量",httpMethod = "POST")
    @PostMapping("/changeReceivable")
    public MessageModel changeReceivable(@ApiParam(name="changeReceivable",value = "订单查询的JSON")@RequestBody OrderDetailsSo orderDetailsSo){
        if(orderService.changeReceivable(orderDetailsSo))
            return MessageModel.success(null,"更新数据成功");
        return MessageModel.fail("更新数据失败");
    }


}
