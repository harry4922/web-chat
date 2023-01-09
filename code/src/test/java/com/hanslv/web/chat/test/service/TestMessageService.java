package com.hanslv.web.chat.test.service;

import com.hanslv.web.chat.dto.res.MessageListResDto;
import com.hanslv.web.chat.dto.res.MessageDetailListResDto;
import com.hanslv.web.chat.services.MessageService;
import com.hanslv.web.chat.test.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/5 11:27
 * @description
 */
@Slf4j
public class TestMessageService extends BaseTest {

    @Autowired
    private MessageService messageService;

    @Test
    public void testGetMessageList(){
        MessageListResDto result = messageService.getMessageList(2);
        result.getMessageInfoList().forEach(info -> log.info(info.toString()));
    }

    @Test
    public void testGetMessageListDetail(){
        MessageDetailListResDto result = messageService.getMessageListDetail(1);
        result.getMessageList().forEach(info -> log.info(info.toString()));
    }
}
