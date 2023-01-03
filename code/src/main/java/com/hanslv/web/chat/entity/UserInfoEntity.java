package com.hanslv.web.chat.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/3 13:19
 * @description 用户信息表
 *
 * USER_INFO
 * ID							ID						BIGINT						PRIMARY KEY					AUTO_INCREMENT
 * 姓名							NAME					VARCHAR(255)
 * 密码							PASS					VARCHAR(255)
 * 创建时间						CREATE_TIME				TIMESTAMP					DEFAULT NOW()
 *
 */
@Data
public class UserInfoEntity {
    /**
     * ID
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 密码
     */
    private String pass;
    /**
     * 创建时间
     */
    private Timestamp createTime;
}
