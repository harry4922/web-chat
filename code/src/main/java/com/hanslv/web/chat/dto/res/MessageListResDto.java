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
 * @date 2023/1/4 9:32
 * @description 消息列表DTO
 */
@ApiModel("消息列表response对象")
@EqualsAndHashCode(callSuper = true)
@Data
public class MessageListResDto extends BaseResDto{
    /**
     * 消息列表
     */
    @ApiModelProperty("消息列表信息List")
    private List<MessageListInfo> messageInfoList = new ArrayList<>();


    /**
     * 消息列表信息
     */
    @ApiModel("消息列表信息")
    @Data
    public static class MessageListInfo{
        /**
         * 会话ID
         */
        @ApiModelProperty("sessionId")
        private Integer sessionId;
        /**
         * 对方用户ID
         */
        @ApiModelProperty("对方用户ID")
        private Integer otherUserId;
        /**
         * 对方用户姓名
         */
        @ApiModelProperty("对方用户姓名")
        private String otherUserName;
        /**
         * 好友状态
         */
        @ApiModelProperty("对方用户与当前用户好友状态")
        private int friendStatus;
        /**
         * 最后消息
         */
        @ApiModelProperty("当前会话最后一条消息")
        private String latestMessage;
        /**
         * 消息状态
         */
        @ApiModelProperty("最后一条消息读取状态")
        private int messageStatus;
    }
}
