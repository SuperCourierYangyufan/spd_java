package com.my.spd.message.SO.MainRoom;

import com.my.spd.message.SO.BaseSo;

/**
 * @author 杨宇帆
 * @create 2019-04-08
 */
public class OrderDetailsSo extends BaseSo {
    private Integer id;
    private Long actuallyReceived;
    private Integer goodId;
    private String lotNumber;

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getActuallyReceived() {
        return actuallyReceived;
    }

    public void setActuallyReceived(Long actuallyReceived) {
        this.actuallyReceived = actuallyReceived;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }
}
