package com.my.spd.message.VO;

import java.util.Date;

/**
 * @author 杨宇帆
 * @create 2019-04-02
 */
public class OrderDetailsVO {
    private Integer id;

    private String lot_number;

    private Date create_time;

    private Integer good_id;

    private Long receivable;

    private Long actually_received;

    private Date production_time;

    private Date expiration_time;

    private Integer uid;

    private Date update_time;

    private Long surplus_quantity;

    private Integer status;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLot_number() {
        return lot_number;
    }

    public void setLot_number(String lot_number) {
        this.lot_number = lot_number;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getGood_id() {
        return good_id;
    }

    public void setGood_id(Integer good_id) {
        this.good_id = good_id;
    }

    public Long getReceivable() {
        return receivable;
    }

    public void setReceivable(Long receivable) {
        this.receivable = receivable;
    }

    public Long getActually_received() {
        return actually_received;
    }

    public void setActually_received(Long actually_received) {
        this.actually_received = actually_received;
    }

    public Date getProduction_time() {
        return production_time;
    }

    public void setProduction_time(Date production_time) {
        this.production_time = production_time;
    }

    public Date getExpiration_time() {
        return expiration_time;
    }

    public void setExpiration_time(Date expiration_time) {
        this.expiration_time = expiration_time;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Long getSurplus_quantity() {
        return surplus_quantity;
    }

    public void setSurplus_quantity(Long surplus_quantity) {
        this.surplus_quantity = surplus_quantity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
