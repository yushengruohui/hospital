package com.ys.hospital.config;

import com.ys.hospital.interceptor.MyMethodInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Description:
 * @author: yusheng
 * @create-date: 2019-09-26 17:23
 **/
@Configuration
public class MyInterceptorConfig extends WebMvcConfigurationSupport {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        /*拦截器按照顺序执行*/
        registry.addInterceptor(new MyMethodInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);

    }
}
