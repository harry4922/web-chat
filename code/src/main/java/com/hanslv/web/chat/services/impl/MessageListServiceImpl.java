package com.hanslv.web.chat.services.impl;

import com.hanslv.web.chat.dao.MessageInfoDao;
import com.hanslv.web.chat.dto.MessageListDto;
import com.hanslv.web.chat.enums.MessageStateEnum;
import com.hanslv.web.chat.po.MessageListPo;
import com.hanslv.web.chat.services.MessageListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/4 9:31
 * @description 消息列表服务
 */
@Service
public class MessageListServiceImpl implements MessageListService {

    @Autowired
    private MessageInfoDao messageInfoDao;

    @Override
    public List<MessageListDto> getMessageList(Integer userId) {
        // 获取消息列表
        List<MessageListPo> messageList = messageInfoDao.messageList(userId, MessageStateEnum.RECEIVED.getCode());
        // 拼装消息
        List<MessageListDto> resultList = new ArrayList<>();
        Map<Integer, MessageListDto> resultMap = new HashMap<>(8);
        messageList.forEach(messageInfo -> {

        });

        return resultList;
    }
}
