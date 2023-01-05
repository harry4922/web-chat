package com.hanslv.web.chat.test.service;

import com.hanslv.web.chat.dto.res.MessageListResDto;
import com.hanslv.web.chat.dto.res.MessageListDetailResDto;
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
        List<MessageListResDto> resultList = messageService.getMessageList(2);
        resultList.forEach(result -> log.info(result.toString()));
    }

    @Test
    public void testGetMessageListDetail(){
        List<MessageListDetailResDto> resultList = messageService.getMessageListDetail(1);
        resultList.forEach(result -> log.info(result.toString()));
    }
}
