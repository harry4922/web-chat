package com.hanslv.web.chat.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author : hansLv
 * @date : 2022/12/30 16:48
 * 聊天消息实体
 */
@Data
public class MessageDto {
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 对方用户ID
     */
    private Integer receiveUserId;
    /**
     * 消息信息
     */
    private String message;
    /**
     * 发送时间
     */
    private LocalDateTime sendTime;
}
