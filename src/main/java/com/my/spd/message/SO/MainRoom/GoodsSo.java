package com.my.spd.message.SO.MainRoom;

import com.my.spd.message.SO.BaseSo;

import java.math.BigDecimal;

/**
 * @author 杨宇帆
 * @create 2019-03-24
 */
public class GoodsSo extends BaseSo {
    private Integer uid;
    private Integer hospitalId;
    private Integer roleid;
    private String name;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }
}
