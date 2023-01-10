package com.hanslv.web.chat.dto.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/5 15:55
 * @description 登录返回对象
 */
@ApiModel("登录response对象")
@EqualsAndHashCode(callSuper = true)
@Data
public class LoginResDto extends BaseResDto{
    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private Integer userId;
    /**
     * 登录结果
     */
    @ApiModelProperty("登录结果")
    private boolean result;
    /**
     * 返回消息
     */
    @ApiModelProperty("登录失败返回消息")
    private String message;
    /**
     * Token
     */
    @ApiModelProperty("用户token")
    private String token;
}
