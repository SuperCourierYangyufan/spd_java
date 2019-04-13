package com.my.spd.service.MainRoom.Impl;

import com.my.spd.dao.StockMapper;
import com.my.spd.message.SO.MainRoom.StockSo;
import com.my.spd.pojo.Stock;
import com.my.spd.pojo.StockExample;
import com.my.spd.service.MainRoom.StockService;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 杨宇帆
 * @create 2019-04-13
 */
@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockMapper stockMapper;


    @Override
    public Stock searchStock(StockSo stockSo) {
        StockExample stockExample = new StockExample();
        stockExample.createCriteria().andUIdEqualTo(stockSo.getUid()).andGoodIdEqualTo(stockSo.getGoodid());
        List<Stock> stocks = stockMapper.selectByExample(stockExample);
        if(CollectionUtils.isEmpty(stocks))
            return null;
        return stocks.get(0);
    }
}
