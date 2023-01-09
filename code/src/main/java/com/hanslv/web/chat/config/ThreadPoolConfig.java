package com.hanslv.web.chat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/3 14:32
 * @description 线程池配置类
 */
@Configuration
public class ThreadPoolConfig {

    /**
     * 默认线程池
     * @return 线程池
     */
    @Bean("defaultExecutor")
    public ThreadPoolTaskExecutor defaultExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(5);
        executor.setKeepAliveSeconds(5);
        return executor;
    }


    /**
     * 定时任务线程池
     * @return 线程池
     */
    @Bean("scheduledsExecutor")
    public ThreadPoolTaskExecutor scheduledsExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(5);
        executor.setKeepAliveSeconds(5);
        return executor;
    }
}
