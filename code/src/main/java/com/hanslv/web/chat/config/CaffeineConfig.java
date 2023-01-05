package com.hanslv.web.chat.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/5 13:12
 * @description Caffeine缓存配置
 */
@Configuration
public class CaffeineConfig {
    /**
     * 其他缓存
     * @return 其他缓存
     */
    @Bean
    public Cache<String, Object> otherCache(){
        return Caffeine.newBuilder().initialCapacity(10240).maximumSize(1024000).expireAfterAccess(Integer.MAX_VALUE, TimeUnit.DAYS).build();
    }
}
