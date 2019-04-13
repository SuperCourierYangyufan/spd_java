package com.my.spd.pojo;

import java.util.Date;

public class Transmission {
    private Integer id;

    private Date createTime;

    private Integer goodId;

    private Integer inUid;

    private Integer outUid;

    private Long number;

    private String inOrderLow;

    private String outOrderLow;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getInUid() {
        return inUid;
    }

    public void setInUid(Integer inUid) {
        this.inUid = inUid;
    }

    public Integer getOutUid() {
        return outUid;
    }

    public void setOutUid(Integer outUid) {
        this.outUid = outUid;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getInOrderLow() {
        return inOrderLow;
    }

    public void setInOrderLow(String inOrderLow) {
        this.inOrderLow = inOrderLow == null ? null : inOrderLow.trim();
    }

    public String getOutOrderLow() {
        return outOrderLow;
    }

    public void setOutOrderLow(String outOrderLow) {
        this.outOrderLow = outOrderLow == null ? null : outOrderLow.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}