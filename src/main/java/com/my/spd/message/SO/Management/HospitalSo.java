package com.my.spd.message.SO.Management;

import com.my.spd.message.SO.BaseSo;

/**
 * @author 杨宇帆
 * @create 2019-03-11
 */
public class HospitalSo extends BaseSo {
    private static final long serialVersionUID = -5478821491080164254L;
    private String address;
    private String type;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
