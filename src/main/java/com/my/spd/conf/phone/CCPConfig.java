package com.my.spd.conf.phone;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 杨宇帆
 * @create 2019-03-19
 */
@Configuration
public class CCPConfig {

    @Bean(name="cCPRestSmsSDK")
    public CCPRestSmsSDK cCPRestSmsSDK(){
        CCPRestSmsSDK sdk = new CCPRestSmsSDK();
        sdk.init("app.cloopen.com","8883");
        sdk.setAccount("8a216da867439e5901674a470e8b0126","9f42b78866c04316a3cfc691c270bb6c");
        sdk.setAppId("8a216da867439e5901674a470ee1012c");
        return sdk;
    }
}
