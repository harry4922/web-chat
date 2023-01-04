package com.hanslv.web.chat.test.dao;

import com.hanslv.web.chat.dao.SessionInfoDao;
import com.hanslv.web.chat.test.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/4 15:40
 * @description
 */
@Slf4j
public class TestSessionInfoDao extends BaseTest {

    @Autowired
    private SessionInfoDao sessionInfoDao;

    @Test
    public void testInsert(){
        Integer userIdA = 2;
        Integer userIdB = 3;
        log.info(sessionInfoDao.insertOne(userIdA, userIdB) + "");
    }
}
