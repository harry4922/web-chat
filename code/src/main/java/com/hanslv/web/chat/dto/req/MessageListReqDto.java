package com.hanslv.web.chat.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/6 15:20
 * @description 消息列表请求对象
 */
@ApiModel("消息列表request对象")
@Data
public class MessageListReqDto {
    /**
     * 当前用户ID
     */
    @ApiModelProperty("用户ID")
    private Integer userId;
}
