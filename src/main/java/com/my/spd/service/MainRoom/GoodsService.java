package com.my.spd.service.MainRoom;

import com.github.pagehelper.PageInfo;
import com.my.spd.message.SO.MainRoom.GoodsSo;
import com.my.spd.pojo.Goods;

/**
 * @author 杨宇帆
 * @create 2019-03-24
 */
public interface GoodsService {
    boolean add(Goods goods);

    boolean update(Goods goods);

    PageInfo<Goods> searchGoods(GoodsSo goodsSo);

    boolean removeGood(Integer id);
}
