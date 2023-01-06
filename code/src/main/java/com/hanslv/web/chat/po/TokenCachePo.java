package com.hanslv.web.chat.po;

import lombok.Data;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/6 9:53
 * @description Token缓存信息
 */
@Data
public class TokenCachePo {
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * Token内容
     */
    private String token;
    /**
     * 创建时间
     */
    private long createTime;
}
