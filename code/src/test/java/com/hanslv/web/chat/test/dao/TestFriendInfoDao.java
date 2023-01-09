package com.hanslv.web.chat.test.dao;

import com.hanslv.web.chat.dao.FriendInfoDao;
import com.hanslv.web.chat.entity.FriendInfoEntity;
import com.hanslv.web.chat.test.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/9 10:21
 * @description
 */
@Slf4j
public class TestFriendInfoDao extends BaseTest {
    @Autowired
    private FriendInfoDao friendInfoDao;

    @Test
    public void testSelectAll(){
        List<FriendInfoEntity> allFriendInfo = friendInfoDao.selectAll();
        allFriendInfo.forEach(info -> log.info(info.toString()));
    }

}
