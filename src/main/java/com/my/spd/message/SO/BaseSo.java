package com.my.spd.message.SO;

import java.io.Serializable;

/**
 * Created by YangYuFan on 2019/2/27.
 */
public class BaseSo implements Serializable {
    private Integer pageSize;
    private Integer pageNum;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
