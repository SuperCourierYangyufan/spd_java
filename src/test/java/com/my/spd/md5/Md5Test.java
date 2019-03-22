package com.my.spd.md5;

import com.my.spd.utils.md5.UserPasswordCheck;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 杨宇帆
 * @create 2019-03-22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Md5Test {
    @Test
    public void fun(){
        SimpleHash hash = new UserPasswordCheck().check("root", "admin");
        System.out.println(hash.toString());
    }
}
