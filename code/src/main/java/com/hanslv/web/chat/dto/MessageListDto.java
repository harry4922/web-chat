package com.hanslv.web.chat.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/4 9:32
 * @description 消息列表DTO
 */
@Data
public class MessageListDto {
    /**
     * 对方用户ID
     */
    private Integer userId;
    /**
     * 对方用户姓名
     */
    private String userName;
    /**
     * 最后消息
     */
    private String lastMessage;
    /**
     * 消息列表
     */
    private List<MessageDto> messageList = new ArrayList<>();
}
