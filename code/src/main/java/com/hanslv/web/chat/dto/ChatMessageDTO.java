package com.hanslv.web.chat.dto;

import lombok.Data;

/**
 * @author : hansLv
 * @date : 2022/12/30 16:48
 * 聊天消息实体
 */
@Data
public class ChatMessageDTO {
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 对方用户ID
     */
    private Integer toUserId;
    /**
     * 消息信息
     */
    private String message;
}
