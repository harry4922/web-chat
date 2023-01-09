package com.hanslv.web.chat.dto.res;

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
@EqualsAndHashCode(callSuper = true)
@Data
public class MessageListResDto extends BaseResDto{
    /**
     * 消息列表
     */
    private List<MessageListInfo> messageInfoList = new ArrayList<>();


    /**
     * 消息列表信息
     */
    @Data
    public static class MessageListInfo{
        /**
         * 会话ID
         */
        private Integer sessionId;
        /**
         * 对方用户ID
         */
        private Integer otherUserId;
        /**
         * 对方用户姓名
         */
        private String otherUserName;
        /**
         * 最后消息
         */
        private String latestMessage;
    }
}
