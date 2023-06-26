package com.hanslv.web.chat.config;

import com.hanslv.web.chat.constants.PagePathConstants;
import com.hanslv.web.chat.interceptor.TokenCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

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
        // Token校验拦截器
        registry.addInterceptor(tokenCheckInterceptor).addPathPatterns("/**");
    }

    /**
     * 页面跳转Controller
     * @param registry 注册器
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        // 主页
        registry.addViewController("/toMain").setViewName(PagePathConstants.PC_MAIN_PAGE);
    }


    /**
     * 静态资源配置
     * @param registry 注册器
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 静态资源
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        // 静态页面
        registry.addResourceHandler("/pages/**")
                .addResourceLocations("classpath:/templates/");
    }


    /**
     * 跨域访问配置
     * @param registry 注册器
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .exposedHeaders("*");
    }
}
