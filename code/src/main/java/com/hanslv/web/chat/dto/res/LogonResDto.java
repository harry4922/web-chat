package com.hanslv.web.chat.dto.res;

import lombok.Data;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/5 15:03
 * @description 注册返回对象
 */
@Data
public class LogonResDto extends BaseResDto{
    /**
     * 注册结果
     */
    private boolean logonResult;
    /**
     * 返回信息
     */
    private String message;
}
