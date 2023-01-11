package com.hanslv.web.chat.services;

import com.hanslv.web.chat.dto.res.MessageListResDto;
import com.hanslv.web.chat.dto.res.MessageDetailListResDto;

import java.util.List;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/4 9:27
 * @description 消息列表服务
 */
public interface MessageService {

    /**
     * 获取发送给当前用户的消息列表
     * @param userId 当前用户ID
     * @return 消息列表
     */
    MessageListResDto getMessageList(Integer userId);

    /**
     * 获取Session的聊天信息
     * @param sessionId SessionID
     * @return 聊天信息列表
     */
    MessageDetailListResDto getMessageListDetail(Integer sessionId);

    /**
     * 更新消息状态
     * @param status 状态
     * @param messageIdList 消息ID列表
     */
    void updateMessageStatus(int status, List<Integer> messageIdList);
}
