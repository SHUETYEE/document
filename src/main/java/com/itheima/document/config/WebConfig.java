package com.itheima.document.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author 李靖宇
 * @Project document
 * @date 2020/1/6 15:24
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/check");
    }
}
