package com.hanslv.web.chat.po;

import lombok.Data;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/4 13:28
 * @description 消息列表
 */
@Data
public class MessageListPo {
    /**
     * 会话ID
     */
    private Integer sessionId;
    /**
     * 对方用户ID
     */
    private Integer otherUserId;
    /**
     * 对方用户名称
     */
    private String otherUserName;
    /**
     * 最后消息
     */
    private String latestMessage;
}
