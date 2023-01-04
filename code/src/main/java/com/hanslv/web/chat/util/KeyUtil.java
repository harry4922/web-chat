package com.hanslv.web.chat.util;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/4 15:24
 * @description Key工具类
 */
public class KeyUtil {
    /**
     * 获取会话Key
     * @param userId 发送用户ID
     * @param receiveUserId 接收用户ID
     * @return SessionKey
     */
    public static String getSessionKey(Integer userId, Integer receiveUserId){
        return userId + "_" + receiveUserId;
    }
}
