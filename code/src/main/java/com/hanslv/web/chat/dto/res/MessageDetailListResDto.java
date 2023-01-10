package com.hanslv.web.chat.dto.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/5 13:46
 * @description 消息返回信息
 */
@ApiModel("消息列表详情response对象")
@EqualsAndHashCode(callSuper = true)
@Data
public class MessageDetailListResDto extends BaseResDto{

    /**
     * 消息列表
     */
    @ApiModelProperty("消息列表详情信息List")
    private List<MessageDetailInfo> messageList = new ArrayList<>();

    /**
     * 消息信息
     */
    @ApiModel("消息列表详情")
    @Data
    public static class MessageDetailInfo{
        /**
         * 消息ID
         */
        @ApiModelProperty("消息ID")
        private Integer messageId;
        /**
         * 用户ID
         */
        @ApiModelProperty("发送用户ID")
        private Integer sendUserId;
        /**
         * 用户姓名
         */
        @ApiModelProperty("发送用户名称")
        private String sendUserName;
        /**
         * 消息
         */
        @ApiModelProperty("消息内容")
        private String message;
        /**
         * 消息时间
         */
        @ApiModelProperty("发送时间")
        private String messageTime;
        /**
         * 消息状态
         */
        @ApiModelProperty("消息状态")
        private int messageStatus;
    }
}
