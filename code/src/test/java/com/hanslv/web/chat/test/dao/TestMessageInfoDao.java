package com.hanslv.web.chat.test.dao;

import com.hanslv.web.chat.dao.MessageInfoDao;
import com.hanslv.web.chat.entity.MessageInfoEntity;
import com.hanslv.web.chat.test.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/3 15:52
 * @description 消息DAO
 */
@Slf4j
public class TestMessageInfoDao extends BaseTest {

    @Autowired
    private MessageInfoDao messageInfoDao;

    @Test
    public void testSelectAll(){
        List<MessageInfoEntity> messageList = messageInfoDao.selectAll();
        messageList.forEach(message -> log.info(message.toString()));
    }


    @Test
    public void testGetNotReceivedMessage(){
        List<MessageInfoEntity> notReceivedMessage = messageInfoDao.selectByUserIdAndNotReceived(223);
        notReceivedMessage.forEach(message -> log.info(message.toString()));
    }
}
