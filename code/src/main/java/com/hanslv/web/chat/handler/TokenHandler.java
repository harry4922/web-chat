package com.hanslv.web.chat.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/6 9:36
 * @description Token处理
 */
@Component
public class TokenHandler {

    @Autowired
    private CaffeineHandler caffeineHandler;

    /**
     * 初始化Token
     * @param userId 用户ID
     * @return token
     */
    public String initToken(Integer userId){
        // 生成Token
        String token = UUID.randomUUID().toString();
        // 将Token放入缓存
        caffeineHandler.setToken(userId, token);
        return token;
    }

    /**
     * Token检查
     * @param userId 用户ID
     * @param token token
     * @return 校验是否成功
     */
    public boolean tokenCheck(Integer userId, String token){
        // 获取Token
        String existToken = caffeineHandler.getToken(userId);
        return token.equals(existToken);
    }

}
