package com.hanslv.web.chat.dto.res;

import lombok.Data;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/5 13:46
 * @description 消息返回信息
 */
@Data
public class MessageListDetailResDto extends BaseResDto{
    /**
     * 用户ID
     */
    private Integer sendUserId;
    /**
     * 用户姓名
     */
    private String sendUserName;
    /**
     * 消息
     */
    private String message;
    /**
     * 消息时间
     */
    private String messageTime;
}
