package com.my.spd.web.job;

import com.my.spd.dao.GoodsMapper;
import com.my.spd.dao.OrderDetailsMapper;
import com.my.spd.dao.OrderMainMapper;
import com.my.spd.dao.UserMapper;
import com.my.spd.message.SO.MainRoom.GoodsSo;
import com.my.spd.pojo.Goods;
import com.my.spd.pojo.OrderDetails;
import com.my.spd.pojo.OrderMain;
import com.my.spd.pojo.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author 杨宇帆
 * @create 2019-03-29
 */
//@Component
public class addOrder {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private OrderMainMapper orderMapper;

    @Autowired
    private OrderDetailsMapper orderDetailsMapper;
    
    public static final String[]  address= {"武汉天辰美亚","黑石药业","德州集团","华石药业"};
    

    @Transactional
    @Scheduled(cron = "* 0/20 * * * *")
    public void addOrder(){
        //查询所有拥有药库的用户
        List<User> users = userMapper.searchHaveWarehouseUsers();
        //随机生成需要添加订单的次数
        int addOrderUserNumber = RandomUtils.nextInt(1, users.size()+1);
        for(int i=0;i<addOrderUserNumber;i++){
            int randomNumber = RandomUtils.nextInt(0, users.size());
            //随机获得用户
            User user = users.get(randomNumber);
            //获得该用户的货物
            GoodsSo so = new GoodsSo();
            so.setHospitalId(user.getHospitalid());
            so.setUid(user.getId());
            so.setRoleid(2);
            List<Goods> goods = goodsMapper.searchGoods(so);
            //生成一张订单主表
            OrderMain order = new OrderMain();
            order.setCreateTime(new Date());
            order.setRid(2);
            order.setStatus(0);
            order.setUid(user.getId());
            order.setUpdateTime(new Date());
            //生成货物单
            String low = RandomStringUtils.randomAlphanumeric(20);
            order.setLotNumber(low);
            int addressRandom = RandomUtils.nextInt(0, address.length);
            order.setAddress(address[addressRandom]);
            //生成订单详情
            List<OrderDetails> orderDetails = new ArrayList<>();
            for(int j=0;j<goods.size()-1;j++){
                if(new Random().nextBoolean()||(j==goods.size()-1&&orderDetails.size()==0)){
                    //添加商品详情
                    OrderDetails details = new OrderDetails();
                    details.setUid(user.getId());
                    details.setCreateTime(new Date());
                    details.setGoodId(goods.get(j).getId());
                    details.setProductionTime(new Date());
                    Date endTime = new Date(details.getProductionTime().getTime() + (long)(goods.get(j).getShelflife()*24*60*60*1000));
                    details.setExpirationTime(endTime);
                    details.setStatus(0);
                    details.setReceivable(RandomUtils.nextLong(1000L, 10000L));
                    details.setUpdateTime(new Date());
                    details.setLotNumber(low);
                    orderDetails.add(details);
                }
            }
            //添加
            order.setGoodNumber(orderDetails.size());
            orderMapper.insertSelective(order);
            orderDetails.forEach(o->orderDetailsMapper.insertSelective(o));
        }
    }
}
