package com.hanslv.web.chat.config;

import com.hanslv.web.chat.interceptor.TokenCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/6 11:02
 * @description WebMvc配置
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private TokenCheckInterceptor tokenCheckInterceptor;

    /**
     * 添加拦截器
     * @param registry 注册器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(tokenCheckInterceptor).addPathPatterns("/**");
    }

}
