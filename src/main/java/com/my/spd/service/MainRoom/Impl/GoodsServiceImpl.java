package com.my.spd.service.MainRoom.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.spd.dao.GoodsMapper;
import com.my.spd.message.SO.MainRoom.GoodsSo;
import com.my.spd.pojo.Goods;
import com.my.spd.pojo.User;
import com.my.spd.service.MainRoom.GoodsService;
import com.my.spd.service.System.Impl.SystemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 杨宇帆
 * @create 2019-03-24
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private SystemServiceImpl systemService;

    @Override
    public boolean add(Goods goods) {
        goods.setCreateTime(new Date());
        if(goodsMapper.insertSelective(goods)==1) return true;
        return false;
    }

    @Override
    public boolean update(Goods goods) {
        if(goodsMapper.updateByPrimaryKeySelective(goods) == 1)return true;
        return false;
    }

    @Override
    public PageInfo<Goods> searchGoods(GoodsSo goodsSo) {
        PageHelper.startPage(goodsSo.getPageNum(), goodsSo.getPageSize());
        //一级库只能拿自己的信息,二级库可以拿全部二级库的信息,和自己id的信息
        List<Goods> goods =  goodsMapper.searchGoods(goodsSo);
        PageInfo<Goods> pageInfo = new PageInfo<>(goods);
        return pageInfo;
    }

    @Override
    public boolean removeGood(Integer id) {
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        User user = systemService.getUser();
        if(!goods.getUid().equals(user.getId()))
            return false;
        goodsMapper.deleteByPrimaryKey(id);
        return true;
    }
    @Override
    public Goods detailGoods(Integer id){
        return goodsMapper.selectByPrimaryKey(id);
    }
}
