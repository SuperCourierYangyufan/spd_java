package com.my.spd.message.SO.MainRoom;

import com.my.spd.message.SO.BaseSo;

/**
 * @author 杨宇帆
 * @create 2019-04-13
 */
public class TransmissionSo extends BaseSo {
    private Integer uid;
    private Integer rid;
    private Integer number;
    private Integer goodid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }
}
