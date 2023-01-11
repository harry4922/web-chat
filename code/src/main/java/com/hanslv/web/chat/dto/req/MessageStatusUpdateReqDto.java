package com.hanslv.web.chat.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/9 17:52
 * @description 更新消息状态请求对象
 */
@ApiModel("批量更新消息状态request对象")
@Data
public class MessageStatusUpdateReqDto {
    /**
     * 状态
     */
    @ApiModelProperty("更新后的消息状态")
    private int status;
    /**
     * 消息ID List
     */
    @ApiModelProperty("消息ID List")
    private List<Integer> messageIdList = new ArrayList<>();
}
