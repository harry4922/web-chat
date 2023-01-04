package com.hanslv.web.chat.entity;

import lombok.Data;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/4 15:16
 * @description 会话信息表
 *
 * SESSION_INFO
 * ID							ID						BIGINT						PRIMARY KEY					AUTO_INCREMENT
 * 关联人ID						RELATION_USER_ID		VARCHAR(255)
 */
@Data
public class SessionInfoEntity {
    /**
     * ID
     */
    private Integer id;
    /**
     * 关联用户ID
     */
    private String relationUserId;
}
