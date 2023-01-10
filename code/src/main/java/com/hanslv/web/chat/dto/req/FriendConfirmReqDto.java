package com.hanslv.web.chat.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/9 15:58
 * @description 好友确认请求对象
 */
@ApiModel("添加好友确认request对象")
@Data
public class FriendConfirmReqDto {
    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private Integer userId;
    /**
     * 好友用户ID
     */
    @ApiModelProperty("好友用户ID")
    private Integer friendUserId;
}
