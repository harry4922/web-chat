package com.hanslv.web.chat.dto.req;

import lombok.Data;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/6 15:22
 * @description 消息列表详情DTO
 */
@Data
public class MessageListDetailReqDto {
    /**
     * 会话ID
     */
    private Integer sessionId;
}
