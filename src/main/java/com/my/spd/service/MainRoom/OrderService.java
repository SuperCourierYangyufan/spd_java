package com.my.spd.service.MainRoom;

import com.github.pagehelper.PageInfo;
import com.my.spd.message.SO.MainRoom.OrderDetailsSo;
import com.my.spd.message.SO.MainRoom.OrderSo;
import com.my.spd.message.VO.OrderDetailsVO;
import com.my.spd.pojo.OrderMain;

/**
 * @author 杨宇帆
 * @create 2019-03-30
 */
public interface OrderService {
    PageInfo<OrderMain> searchOrders(OrderSo orderSo);

    PageInfo<OrderDetailsVO> showItem(OrderSo orderSo);

    boolean changeReceivable(OrderDetailsSo orderDetailsSo);
}
