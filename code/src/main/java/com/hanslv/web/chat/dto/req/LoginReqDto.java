package com.hanslv.web.chat.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/5 15:54
 * @description 登录请求对象
 */
@ApiModel("登录request对象")
@Data
public class LoginReqDto {
    /**
     * 用户名
     */
    @ApiModelProperty("姓名")
    private String name;
    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;
}
