package com.hanslv.web.chat.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/9 14:04
 * @description 添加好友请求
 */
@ApiModel("添加好友request对象")
@Data
public class FriendAddReqDto {
    /**
     * 当前用户ID
     */
    @ApiModelProperty("用户ID")
    private Integer userId;
    /**
     * 好友用户ID
     */
    @ApiModelProperty("好友用户ID")
    private Integer friendUserId;
}
