package com.hanslv.web.chat.entity;

import lombok.Data;

/**
 * @author : hansLv
 * @date : 2022/12/30 16:48
 * 聊天消息实体
 */
@Data
public class ChatMessageEntity {
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 对方用户ID
     */
    private String toUserId;
    /**
     * 消息信息
     */
    private String message;
}
