package com.hanslv.web.chat.util;

import com.github.benmanes.caffeine.cache.Cache;
import com.hanslv.web.chat.constants.CaffeineConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/5 13:13
 * @description Caffeine工具类
 */
@Component
public class CaffeineUtil {

    @Autowired
    private Cache<String, Object> otherCache;

    /**
     * 向其他缓存中添加数据
     * @param key KEY
     * @param value 值
     */
    public void addOtherCache(String key, Object value){
        otherCache.put(key, value);
    }

    /**
     * 从其他缓存中获取数据
     * @param key KEY
     * @param <T> 数据类型
     * @return 数据
     */
    public <T> T getOtherCache(String key){
        Object cacheObj = otherCache.get(key, n -> null);
        if(cacheObj != null){
            return (T) cacheObj;
        }
        return null;
    }

    /**
     * 初始化Session序号
     * @param indexNum 序号
     */
    public void initSessionIndex(int indexNum){
        AtomicInteger index = new AtomicInteger();
        index.set(indexNum);
        addOtherCache(CaffeineConstants.SESSION_INDEX_KEY, index);
    }

    /**
     * 获取Session序号
     * @return 序号
     */
    public int getNextSessionIndex(){
        // 获取session序号
        AtomicInteger index = getOtherCache(CaffeineConstants.SESSION_INDEX_KEY);
        // 序号+1
        return index.incrementAndGet();
    }

    /**
     * 获取当前session序号
     * @return 序号
     */
    public int getSessionIndex(){
        // 获取session序号
        AtomicInteger index = getOtherCache(CaffeineConstants.SESSION_INDEX_KEY);
        return index.get();
    }
}
