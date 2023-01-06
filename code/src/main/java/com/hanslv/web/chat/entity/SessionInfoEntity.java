package com.hanslv.web.chat.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/4 15:16
 * @description 会话信息表
 *
 * SESSION_INFO
 * ID							ID						BIGINT						PRIMARY KEY
 * 用户ID						USER_ID					BIGINT						PRIMARY KEY
 * 最后消息ID						LATEST_MESSAGE_ID		BIGINT
 * 创建时间						CREATE_TIME				TIMESTAMP					DEFAULT NOW()
 *
 */
@Data
public class SessionInfoEntity {
    /**
     * ID
     */
    private Integer id;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 最后
     */
    private Integer latestMessageId;
    /**
     * 创建时间
     */
    private Timestamp createTime;
}
