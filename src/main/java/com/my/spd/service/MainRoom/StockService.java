package com.my.spd.service.MainRoom;

import com.my.spd.message.SO.MainRoom.StockSo;
import com.my.spd.pojo.Stock;

/**
 * @author 杨宇帆
 * @create 2019-04-13
 */
public interface StockService {
    Stock searchStock(StockSo stockSo);
}
