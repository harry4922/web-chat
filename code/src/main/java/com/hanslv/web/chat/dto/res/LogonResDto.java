package com.hanslv.web.chat.dto.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/5 15:03
 * @description 注册返回对象
 */
@ApiModel("注册response对象")
@EqualsAndHashCode(callSuper = true)
@Data
public class LogonResDto extends BaseResDto{
    /**
     * 注册结果
     */
    @ApiModelProperty("注册结果")
    private boolean logonResult;
    /**
     * 返回信息
     */
    @ApiModelProperty("注册失败返回信息")
    private String message;
}
