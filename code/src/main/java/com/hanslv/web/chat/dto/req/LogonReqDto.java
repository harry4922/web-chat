package com.hanslv.web.chat.dto.req;

import lombok.Data;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/5 15:02
 * @description 注册请求对象
 */
@Data
public class LogonReqDto {
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
}
