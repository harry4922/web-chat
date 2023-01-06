package com.hanslv.web.chat.handler;

import com.github.benmanes.caffeine.cache.Cache;
import com.hanslv.web.chat.constants.CaffeineConstants;
import com.hanslv.web.chat.po.TokenCachePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/5 13:13
 * @description Caffeine工具类
 */
@Component
public class CaffeineHandler {

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

    /**
     * 获取Token池
     * @return Token池
     */
    public Map<Integer, TokenCachePo> getTokenPool(){
        Map<Integer, TokenCachePo> tokenPool = getOtherCache(CaffeineConstants.TOKEN_KEY);
        if(tokenPool == null){
            tokenPool = new ConcurrentHashMap<>(8);
            addOtherCache(CaffeineConstants.TOKEN_KEY, tokenPool);
        }
        return tokenPool;
    }

    /**
     * 获取Token缓存对象
     * @param userId 用户ID
     * @return 缓存对象
     */
    public TokenCachePo getTokenCache(Integer userId){
        // 获取Token池
        Map<Integer, TokenCachePo> tokenPool = getTokenPool();
        // 获取Token缓存对象
        TokenCachePo tokenCachePo = tokenPool.get(userId);
        if(tokenCachePo == null){
            tokenCachePo = new TokenCachePo();
            tokenCachePo.setUserId(userId);
            tokenPool.put(userId, tokenCachePo);
        }
        return tokenCachePo;
    }

    /**
     * 放置Token缓存对象
     * @param userId 用户ID
     * @param token Token
     */
    public void setToken(Integer userId, String token){
        // 获取Token缓存对象
        TokenCachePo tokenCachePo = getTokenCache(userId);
        tokenCachePo.setToken(token);
        tokenCachePo.setCreateTime(System.currentTimeMillis());
    }

    /**
     * 获取Token
     * @param userId 用户ID
     * @return token
     */
    public String getToken(Integer userId){
        // 获取Token缓存对象
        TokenCachePo tokenCachePo = getTokenCache(userId);
        return tokenCachePo.getToken();
    }
}
