package com.hanslv.web.chat.services;

import com.hanslv.web.chat.dto.MessageListDto;

import java.util.List;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/4 9:27
 * @description 消息列表服务
 */
public interface MessageListService {

    /**
     * 获取发送给当前用户的消息列表
     * @param userId 当前用户ID
     * @return 消息列表
     */
    List<MessageListDto> getMessageList(Integer userId);
}
