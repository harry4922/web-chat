package com.hanslv.web.chat.dto.res;

import lombok.Data;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/4 9:32
 * @description 消息列表DTO
 */
@Data
public class MessageListResDto extends BaseResDto{
    /**
     * 会话ID
     */
    private Integer sessionId;
    /**
     * 对方用户ID
     */
    private Integer otherUserId;
    /**
     * 对方用户姓名
     */
    private String otherUserName;
    /**
     * 最后消息
     */
    private String latestMessage;
}
