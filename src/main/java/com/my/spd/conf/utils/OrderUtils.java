package com.my.spd.conf.utils;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author 杨宇帆
 * @create 2019-04-12
 */
public class OrderUtils {
    public static String getLotNmber(){
        return RandomStringUtils.randomAlphanumeric(20);
    }
}
