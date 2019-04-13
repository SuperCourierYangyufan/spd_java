package com.my.spd.message.SO.MainRoom;

import com.my.spd.message.SO.BaseSo;

/**
 * @author 杨宇帆
 * @create 2019-04-13
 */
public class StockSo extends BaseSo {
    private Integer uid;
    private Integer goodid;

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
