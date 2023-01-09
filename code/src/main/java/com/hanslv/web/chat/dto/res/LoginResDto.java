package com.hanslv.web.chat.dto.res;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/5 15:55
 * @description 登录返回对象
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LoginResDto extends BaseResDto{
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 登录结果
     */
    private boolean result;
    /**
     * 返回消息
     */
    private String message;
    /**
     * Token
     */
    private String token;
}
