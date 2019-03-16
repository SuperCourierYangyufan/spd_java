package com.my.spd.conf.interceptor;

import com.my.spd.web.interceptor.CrosInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author 杨宇帆
 * @create 2019-03-11
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    //Cros 跨域
    @Autowired
    private CrosInterceptor crosInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(crosInterceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
