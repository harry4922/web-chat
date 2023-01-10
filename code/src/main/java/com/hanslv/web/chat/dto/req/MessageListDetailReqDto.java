package com.hanslv.web.chat.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/6 15:22
 * @description 消息列表详情DTO
 */
@ApiModel("消息列表详情request对象")
@Data
public class MessageListDetailReqDto {
    /**
     * 会话ID
     */
    @ApiModelProperty("sessionId")
    private Integer sessionId;
}
