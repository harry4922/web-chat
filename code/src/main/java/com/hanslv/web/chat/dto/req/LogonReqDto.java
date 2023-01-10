package com.hanslv.web.chat.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/5 15:02
 * @description 注册请求对象
 */
@ApiModel("注册request对象")
@Data
public class LogonReqDto {
    /**
     * 用户姓名
     */
    @ApiModelProperty("用户名")
    private String name;
    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;
}
