package com.hanslv.web.chat.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/3 13:25
 * @description 消息实体
 *
 * MESSAGE_INFO
 * ID							ID						BIGINT						PRIMARY KEY					AUTO_INCREMENT
 * 用户ID						USER_ID					BIGINT
 * 接收用户ID						RECEIVE_USER_ID			BIGINT
 * 消息信息						MESSAGE					VARCHAR(255)
 * 消息状态						STATUS					INT
 * 创建时间						CREATE_TIME				TIMESTAMP					DEFAULT NOW()
 */
@Data
public class MessageInfoEntity {
    /**
     * ID
     */
    private Integer id;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 接收方用户ID
     */
    private Integer ReceiveUserId;
    /**
     * 消息信息
     */
    private String message;
    /**
     * 消息状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Timestamp createTime;
}
