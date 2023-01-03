package com.hanslv.web.chat.config;

import com.hanslv.web.chat.entity.MessageInfoEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/3 14:53
 * @description 消息信息配置类
 */
@Configuration
public class MessageConfig {

    /**
     * 获取未持久化缓存池
     * @return 缓存池
     */
    @Bean("NPP")
    public List<MessageInfoEntity> getNotPersistenceMessagePool(){
        return new CopyOnWriteArrayList<>();
    }

    /**
     * 获取未持久化备用缓存池
     * @return 备用缓存池
     */
    @Bean("NPPB")
    public List<MessageInfoEntity> getNotPersistenceMessagePoolBuffer(){
        return new CopyOnWriteArrayList<>();
    }

    /**
     * 是否使用备用缓存池
     * @return 开关
     */
    @Bean("NPPBFlag")
    public AtomicBoolean getNPPBFlag(){
        return new AtomicBoolean();
    }
}
