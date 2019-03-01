package com.my.spd.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by YangYuFan on 2019/2/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class shiroTest {

    @Test
    public void fun(){
        String hashAlgorithName = "MD5";
        String password = "admin";
        int hashIterations = 1;//加密次数
        ByteSource credentialsSalt = ByteSource.Util.bytes("root");
        Object obj = new SimpleHash(hashAlgorithName, password, credentialsSalt, hashIterations);
        System.out.println(obj);
    }
}
