package com.my.spd.message.SO.Management;

import com.my.spd.message.SO.BaseSo;

/**
 * @author 杨宇帆
 * @create 2019-03-16
 */
public class UserSo extends BaseSo {
    private String name;
    private Integer hospitalId;
    private Integer roleid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
