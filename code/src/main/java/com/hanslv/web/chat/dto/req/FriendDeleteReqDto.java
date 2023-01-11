package com.hanslv.web.chat.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/9 16:04
 * @description 删除好友请求对象
 */
@ApiModel("删除好友request对象")
@Data
public class FriendDeleteReqDto {
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
