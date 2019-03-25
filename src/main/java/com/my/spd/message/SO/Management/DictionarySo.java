package com.my.spd.message.SO.Management;

import com.my.spd.message.SO.BaseSo;

/**
 * Created by YangYuFan on 2019/2/27.
 */
public class DictionarySo extends BaseSo {
    private static final long serialVersionUID = -1704883852646154645L;
    private String name;

    private String category;

    private Integer value;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
