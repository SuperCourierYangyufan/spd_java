package com.my.spd.web.controller.MainRoom;

import com.my.spd.message.MessageModel;
import com.my.spd.message.SO.MainRoom.StockSo;
import com.my.spd.pojo.Stock;
import com.my.spd.service.MainRoom.StockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨宇帆
 * @create 2019-04-13
 */
@RestController
@Api(description = "库存表接口")
@RequestMapping("/mainroom")
public class StockController {
    @Autowired
    private StockService stockService;

    @ApiOperation(value = "根据条件查询库存信息",httpMethod = "POST")
    @RequestMapping("/searchStock")
    public MessageModel searchStock(@ApiParam(name="stockSo",value ="库存查询条件" ) @RequestBody StockSo stockSo){
        if(stockSo.getGoodid()==null||stockSo.getUid()==null)
            return MessageModel.fail("参数为空");
        Stock stock = stockService.searchStock(stockSo);
        if(stock!=null)
            return MessageModel.success(stock);
        return MessageModel.success(null,"查询无该商品记录");
    }

}
