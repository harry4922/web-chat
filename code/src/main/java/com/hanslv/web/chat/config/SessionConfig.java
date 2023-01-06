package com.hanslv.web.chat.config;

import com.hanslv.web.chat.dao.SessionInfoDao;
import com.hanslv.web.chat.handler.CaffeineHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/5 13:31
 * @description 初始化SessionID
 */
@Configuration
public class SessionConfig {

    @Autowired
    private SessionInfoDao sessionInfoDao;

    @Autowired
    private CaffeineHandler caffeineHandler;

    @PostConstruct
    public void init(){
        // 初始化SessionIndex
        int maxSessionId = sessionInfoDao.selectMaxSessionId();
        caffeineHandler.initSessionIndex(maxSessionId);
    }
}
