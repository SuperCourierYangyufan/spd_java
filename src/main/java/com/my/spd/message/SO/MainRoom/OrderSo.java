package com.my.spd.message.SO.MainRoom;

import com.my.spd.message.SO.BaseSo;

/**
 * @author 杨宇帆
 * @create 2019-03-30
 */
public class OrderSo extends BaseSo {
    private Integer id;
    private String lotNumber;
    private Integer status;
    private Integer uid;
    private Integer rid;


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

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
