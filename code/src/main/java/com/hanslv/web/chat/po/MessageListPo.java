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
     * 消息ID
     */
    private Integer messageId;
    /**
     * 消息
     */
    private String message;
    /**
     * 消息状态
     */
    private int messageStatus;
    /**
     * 发送人ID
     */
    private Integer sendUserId;
    /**
     * 发送人名称
     */
    private String sendUserName;
    /**
     * 接收人ID
     */
    private Integer receiveUserId;
    /**
     * 接收人姓名
     */
    private String receiveUserName;

}
