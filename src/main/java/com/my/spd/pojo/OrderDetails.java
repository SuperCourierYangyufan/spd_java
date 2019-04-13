package com.my.spd.pojo;

import java.util.Date;

public class OrderDetails {
    private Integer id;

    private String lotNumber;

    private Date createTime;

    private Integer goodId;

    private Long receivable;

    private Long actuallyReceived;

    private Date productionTime;

    private Date expirationTime;

    private Integer uid;

    private Date updateTime;

    private Long surplusQuantity;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber == null ? null : lotNumber.trim();
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

    public Long getReceivable() {
        return receivable;
    }

    public void setReceivable(Long receivable) {
        this.receivable = receivable;
    }

    public Long getActuallyReceived() {
        return actuallyReceived;
    }

    public void setActuallyReceived(Long actuallyReceived) {
        this.actuallyReceived = actuallyReceived;
    }

    public Date getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(Date productionTime) {
        this.productionTime = productionTime;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getSurplusQuantity() {
        return surplusQuantity;
    }

    public void setSurplusQuantity(Long surplusQuantity) {
        this.surplusQuantity = surplusQuantity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}