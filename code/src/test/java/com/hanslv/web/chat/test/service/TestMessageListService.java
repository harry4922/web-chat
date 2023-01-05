package com.hanslv.web.chat.test.service;

import com.hanslv.web.chat.dto.MessageListDto;
import com.hanslv.web.chat.services.MessageListService;
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
public class TestMessageListService extends BaseTest {

    @Autowired
    private MessageListService messageListService;

    @Test
    public void testGetMessageList(){
        List<MessageListDto> resultList = messageListService.getMessageList(2);
        resultList.forEach(result -> log.info(result.toString()));
    }
}
