package com.my.spd.utils.md5;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author 杨宇帆
 * @create 2019-03-22
 */
public class UserPasswordCheck {
    public SimpleHash check(String username,String password){
        ByteSource byteSource = ByteSource.Util.bytes(username);
        return new SimpleHash("MD5", password, byteSource, 1);
    }
}
