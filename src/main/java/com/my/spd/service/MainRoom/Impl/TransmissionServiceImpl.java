package com.my.spd.service.MainRoom.Impl;

import com.my.spd.conf.utils.OrderUtils;
import com.my.spd.dao.OrderDetailsMapper;
import com.my.spd.dao.OrderMainMapper;
import com.my.spd.dao.TransmissionMapper;
import com.my.spd.message.MessageModel;
import com.my.spd.message.SO.MainRoom.TransmissionSo;
import com.my.spd.pojo.Goods;
import com.my.spd.pojo.OrderDetails;
import com.my.spd.pojo.OrderMain;
import com.my.spd.pojo.Transmission;
import com.my.spd.service.MainRoom.GoodsService;
import com.my.spd.service.MainRoom.TransmissionService;
import com.my.spd.service.System.Impl.SystemServiceImpl;
import org.apache.commons.lang3.RandomUtils;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 杨宇帆
 * @create 2019-04-13
 */
@Service
public class TransmissionServiceImpl implements TransmissionService {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private TransmissionMapper transmissionMapper;

    @Autowired
    private OrderMainMapper orderMainMapper;

    @Autowired
    private OrderDetailsMapper orderDetailsMapper;

    @Autowired
    private SystemServiceImpl systemService;

    public static final String[]  address= {"武汉天辰美亚","黑石药业","德州集团","华石药业"};

    @Transactional
    @Override
    public MessageModel saveRequestForm(List<TransmissionSo> transmissionSoList) {
        List<OrderDetails> orderDetails = new ArrayList<>();
        for(TransmissionSo so : transmissionSoList){
            if(so.getNumber()==null||so.getNumber().equals(0))
                return MessageModel.fail("请求货物数量不能为空");
            //查询货物详情
            Goods goods = goodsService.detailGoods(so.getGoodid());
            Transmission transmission = new Transmission();
            transmission.setCreateTime(new Date());
            transmission.setGoodId(goods.getId());
            transmission.setNumber(Long.parseLong(so.getNumber().toString()));
            transmission.setStatus(0);
            transmission.setInUid(so.getUid());
            transmission.setOutUid(goods.getUid());

            //一级库或者该货物为自己所生成且为二级库
            if(so.getRid().equals(2)||(so.getRid().equals(3)&&so.getUid().equals(goods.getUid()))){
                OrderDetails details = new OrderDetails();
                details.setStatus(0);
                details.setCreateTime(new Date());
                details.setUpdateTime(new Date());
                details.setGoodId(goods.getId());
                details.setReceivable(Long.parseLong(so.getNumber().toString()));
                details.setUid(so.getUid());
                details.setProductionTime(new Date());
                Date endTime = new Date(new Date().getTime() + (long)(goods.getShelflife()*24*60*60*1000));
                details.setExpirationTime(endTime);
                orderDetails.add(details);

                transmission.setStatus(1);
            }

            transmissionMapper.insertSelective(transmission);
        }
        if(!CollectionUtils.isEmpty(orderDetails)){
            //生成入库单
            String lotNmber = OrderUtils.getLotNmber();
            //封装主单
            OrderMain orderMain = new OrderMain();
            orderMain.setUid(systemService.getUser().getId());
            orderMain.setGoodNumber(orderDetails.size());
            orderMain.setCreateTime(new Date());
            orderMain.setLotNumber(lotNmber);
            orderMain.setRid(transmissionSoList.get(0).getRid());
            orderMain.setStatus(0);
            orderMain.setUpdateTime(new Date());
            orderMain.setAddress(address[RandomUtils.nextInt(0, address.length-1)]);
            orderMainMapper.insertSelective(orderMain);
            //循环生成详细
            orderDetails.forEach(i->{
                i.setLotNumber(lotNmber);
                orderDetailsMapper.insertSelective(i);
            });

        }
        return MessageModel.success(null, "申请成功");
    }
}
