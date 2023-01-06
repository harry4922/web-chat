package com.hanslv.web.chat.controllers;

import com.hanslv.web.chat.dto.req.MessageListDetailReqDto;
import com.hanslv.web.chat.dto.req.MessageListReqDto;
import com.hanslv.web.chat.dto.res.MessageListDetailResDto;
import com.hanslv.web.chat.dto.res.MessageListResDto;
import com.hanslv.web.chat.interfaces.TokenCheck;
import com.hanslv.web.chat.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/4 9:27
 * @description 消息列表
 */
@RequestMapping("/messageList")
@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * 获取消息列表
     * @param reqDto 请求对象
     * @return 消息列表
     */
    @TokenCheck
    @PostMapping("/")
    public List<MessageListResDto> getMessageList(@RequestBody MessageListReqDto reqDto){
        return messageService.getMessageList(reqDto.getUserId());
    }

    /**
     * 获取消息列表详情
     * @param reqDto 请求对象
     * @return 消息列表详情
     */
    @TokenCheck
    @PostMapping("/detail")
    public List<MessageListDetailResDto> getMessageListDetail(@RequestBody MessageListDetailReqDto reqDto){
        return messageService.getMessageListDetail(reqDto.getSessionId());
    }
}
