package com.hanslv.web.chat.dto.res;

import lombok.Data;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/9 13:40
 * @description 基本返回对象Dto
 */
@Data
public class BaseResDto {
    /**
     * 响应编码
     */
    private int responseCode;
    /**
     * 相应信息
     */
    private String resMessage;
}
