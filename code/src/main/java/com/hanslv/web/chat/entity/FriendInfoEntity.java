package com.hanslv.web.chat.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/9 10:11
 * @description 好友关系列表
 * FRIEND_INFO
 * 当前用户ID						USER_ID										BIGINT						PRIMARY KEY
 * 好友用户ID						FRIEND_USER_ID								BIGINT						PRIMARY KEY
 * 状态							STATUS										INT
 * 创建时间						CREATE_TIME									TIMESTAMP					DEFAULT NOW()
 */
@Data
public class FriendInfoEntity {
    /**
     * 当前用户ID
     */
    private Integer userId;
    /**
     * 好友用户ID
     */
    private Integer friendUserId;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Timestamp createTime;
}
