package com.my.spd.ccp;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.my.spd.conf.baseConf.BaseConf;
import com.my.spd.utils.Send.MessageSend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 杨宇帆
 * @create 2019-03-19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ccpTest {
    @Autowired
    private CCPRestSmsSDK ccpRestSmsSDK;

    @Autowired
    private MessageSend messageSend;

    @Autowired
    private BaseConf baseConf;

    @Test
    public void fun(){
//        ccpRestSmsSDK.sendTemplateSMS("18827421758", "1", new String[]{"1","2"});

        String path = "<a href='http://localhost:8081/management/activateUser/19'><span>您好,亲爱的312312312,欢迎使用本SPD产品,请点击我前往激活账号</span></a>";
        messageSend.sendMail("852287099@qq.com", path);

        System.out.println(baseConf.getJavaAddress());
    }
}
