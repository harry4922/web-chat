package com.hanslv.web.chat.po;

import lombok.Data;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/5 13:52
 * @description 消息实体
 */
@Data
public class MessageInfoPo {
    /**
     * 消息ID
     */
    private Integer messageId;
    /**
     * 发送人ID
     */
    private Integer sendUserId;
    /**
     * 发送人姓名
     */
    private String sendUserName;
    /**
     * 消息
     */
    private String message;
    /**
     * 发送时间
     */
    private String messageTime;
    /**
     * 消息状态
     */
    private int messageStatus;
}
