package com.my.spd.conf.baseConf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by YangYuFan on 2019/2/23.
 */
@Configuration
@ConfigurationProperties(prefix = "com.my.spd")
public class BaseConf {
    //分页每页查询的条数
    private Integer pageSize;

    //执行成功状态码
    private String successCode;

    //执行失败状态吗
    private String failCode;

    //后台地址
    private String javaAddress;

    //前台地址
    private String vueAddress;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSuccessCode() {
        return successCode;
    }

    public void setSuccessCode(String successCode) {
        this.successCode = successCode;
    }

    public String getFailCode() {
        return failCode;
    }

    public void setFailCode(String failCode) {
        this.failCode = failCode;
    }

    public String getJavaAddress() {
        return javaAddress;
    }

    public void setJavaAddress(String javaAddress) {
        this.javaAddress = javaAddress;
    }

    public String getVueAddress() {
        return vueAddress;
    }

    public void setVueAddress(String vueAddress) {
        this.vueAddress = vueAddress;
    }
}
