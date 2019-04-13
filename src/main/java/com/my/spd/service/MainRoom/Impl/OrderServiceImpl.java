package com.my.spd.service.MainRoom.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.spd.dao.OrderDetailsMapper;
import com.my.spd.dao.OrderMainMapper;
import com.my.spd.dao.StockMapper;
import com.my.spd.message.SO.MainRoom.OrderDetailsSo;
import com.my.spd.message.SO.MainRoom.OrderSo;
import com.my.spd.message.VO.OrderDetailsVO;
import com.my.spd.pojo.*;
import com.my.spd.service.MainRoom.OrderService;
import com.my.spd.service.System.Impl.SystemServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;

/**
 * @author 杨宇帆
 * @create 2019-03-30
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMainMapper orderMainMapper;

    @Autowired
    private OrderDetailsMapper orderDetailsMapper;

    @Autowired
    private StockMapper stockMapper;

    @Autowired
    private SystemServiceImpl systemService;

    private static  final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);


    @Override
    public PageInfo<OrderMain> searchOrders(OrderSo orderSo) {
        PageHelper.startPage(orderSo.getPageNum(), orderSo.getPageSize());
        OrderMainExample mainExample = new OrderMainExample();
        OrderMainExample.Criteria criteria = mainExample.createCriteria();
        if(orderSo.getRid() == null||orderSo.getRid().equals(0)||orderSo.getUid()==null||orderSo.getUid().equals(0))
            return null;
        criteria.andUidEqualTo(orderSo.getUid());
        criteria.andRidEqualTo(orderSo.getRid());
        //条件查询
        if(StringUtils.isNotBlank(orderSo.getLotNumber()))criteria.andLotNumberLike("%"+orderSo.getLotNumber()+"%");
        if(orderSo.getStatus()!=null)criteria.andStatusEqualTo(orderSo.getStatus());
        //查询
        List<OrderMain> orderMains = orderMainMapper.selectByExample(mainExample);
        PageInfo<OrderMain> info = new PageInfo<>(orderMains);
        return info;
    }

    @Override
    public PageInfo<OrderDetailsVO> showItem(OrderSo so) {
        OrderMain orderMain = orderMainMapper.selectByPrimaryKey(so.getId());
        PageHelper.startPage(so.getPageNum(), so.getPageSize());
        List<OrderDetailsVO> orderDetails = orderDetailsMapper.selectDetails(orderMain.getLotNumber());
        PageInfo<OrderDetailsVO> info = new PageInfo<>(orderDetails);
        return info;
    }
    @Transactional
    @Override
    public boolean changeReceivable(OrderDetailsSo orderDetailsSo) {
       try {
           OrderDetails details = new OrderDetails();
           BeanUtils.copyProperties(orderDetailsSo, details);
           details.setStatus(1);
           int i = orderDetailsMapper.updateByPrimaryKeySelective(details);
           if(i!=1)return false;
           //更新库存
           StockExample stockExample = new StockExample();
           stockExample.createCriteria().andUIdEqualTo(systemService.getUser().getId());
           List<Stock> stocks = stockMapper.selectByExample(stockExample);
           Integer flag = 1;
           Stock stock = new Stock();
           if(stocks!=null&&stocks.size()>0){
               for(Stock s:stocks){
                   if(s.getGoodId().equals(orderDetailsSo.getGoodId())){
                       flag = 2;
                       BeanUtils.copyProperties(s, stock);
                       break;
                   }
               }
           }
           if(flag.equals(2)){
               //有该数据
               logger.info(stock.getNumber().longValue()+"||||||||||||||"+orderDetailsSo.getActuallyReceived().longValue());
               Long l = stock.getNumber().longValue() + orderDetailsSo.getActuallyReceived().longValue();
               stock.setNumber(l);
               stock.setUpdateTime(new Date());
               stockMapper.updateByPrimaryKeySelective(stock);
           }else{
               //没有
               //插入库存数据
               stock.setGoodId(orderDetailsSo.getGoodId());
               stock.setNumber(orderDetailsSo.getActuallyReceived());
               stock.setuId(systemService.getUser().getId());
               stock.setUpdateTime(new Date());
               stockMapper.insertSelective(stock);
           }
           //判断步骤
           List<OrderDetailsVO> orderDetailsVOS = orderDetailsMapper.selectDetails(orderDetailsSo.getLotNumber());
           OrderMainExample example = new OrderMainExample();
           example.createCriteria().andLotNumberEqualTo(orderDetailsSo.getLotNumber());
           OrderMain orderMain = orderMainMapper.selectByExample(example).get(0);
           Integer count = (int)orderDetailsVOS.stream().filter(v -> v.getStatus() == 1).count();
           if(count.equals(orderMain.getGoodNumber())){
               //全部收集
               orderMain.setStatus(2);
           }else if(count.equals(1)){
               //刚收集第一件货物
               orderMain.setStatus(1);
           }
           orderMainMapper.updateByPrimaryKeySelective(orderMain);
           return true;
       }catch (Exception e){
           logger.error("changeReceivable()出错了"+e.getMessage());
           TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
           return false;
       }
    }
}
