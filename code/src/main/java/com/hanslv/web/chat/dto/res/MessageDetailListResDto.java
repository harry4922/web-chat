package com.hanslv.web.chat.dto.res;

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
@EqualsAndHashCode(callSuper = true)
@Data
public class MessageDetailListResDto extends BaseResDto{

    /**
     * 消息列表
     */
    private List<MessageDetailInfo> messageList = new ArrayList<>();

    /**
     * 消息信息
     */
    @Data
    public static class MessageDetailInfo{
        /**
         * 消息ID
         */
        private Integer messageId;
        /**
         * 用户ID
         */
        private Integer sendUserId;
        /**
         * 用户姓名
         */
        private String sendUserName;
        /**
         * 消息
         */
        private String message;
        /**
         * 消息时间
         */
        private String messageTime;
        /**
         * 消息状态
         */
        private int messageStatus;
    }
}
