package com.my.spd.web.controller.MainRoom;

import com.github.pagehelper.PageInfo;
import com.my.spd.message.MessageModel;
import com.my.spd.message.SO.MainRoom.GoodsSo;
import com.my.spd.pojo.Goods;
import com.my.spd.service.MainRoom.GoodsService;
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
 * @create 2019-03-24
 */
@Api(description = "货物接口")
@RestController
@RequestMapping("/mainroom")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @ApiOperation(value = "货物商品",httpMethod = "POST")
    @PostMapping("/saveGood")
    public MessageModel saveGood(@ApiParam(name="goods",value = "商品Json对象") @RequestBody Goods goods){
        if(goods.getId()==null||goods.getId() == 0){
            //新增
            if(goodsService.add(goods))
                return MessageModel.success(null, "添加成功");

        }else{
            if(goodsService.update(goods))
                return MessageModel.success(null, "更新成功");
        }
        return MessageModel.fail("保存异常");
    }

    @ApiOperation(value = "货物分页查询",httpMethod = "POST")
    @PostMapping("/searchGoods")
    public MessageModel searchGoods(@ApiParam(name="goods",value = "商品查询条件Json对象") @RequestBody GoodsSo goodsSo){
        if(goodsSo.getHospitalId() == null&&goodsSo.getHospitalId() == 0)
            return MessageModel.fail("没有医院");
        if(goodsSo.getUid() == null&&goodsSo.getUid() == 0)
            return MessageModel.fail("没有用户");
        PageInfo<Goods> goodsPageInfo =goodsService.searchGoods(goodsSo);
        if(goodsPageInfo!=null)
            return MessageModel.success(goodsPageInfo);
        return MessageModel.fail("查询异常");
    }

}
