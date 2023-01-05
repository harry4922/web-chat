package com.hanslv.web.chat.services.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hanslv.web.chat.dao.MessageInfoDao;
import com.hanslv.web.chat.dto.res.MessageListResDto;
import com.hanslv.web.chat.dto.res.MessageListDetailResDto;
import com.hanslv.web.chat.enums.MessageStateEnum;
import com.hanslv.web.chat.po.MessageInfoPo;
import com.hanslv.web.chat.po.MessageListPo;
import com.hanslv.web.chat.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/4 9:31
 * @description 消息列表服务
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageInfoDao messageInfoDao;

    @Override
    public List<MessageListResDto> getMessageList(Integer userId) {
        // 获取消息列表
        List<MessageListPo> messageList = messageInfoDao.messageList(userId, MessageStateEnum.RECEIVED.getCode());
        // 拼装消息
        List<MessageListResDto> resultList = new ArrayList<>();
        messageList.forEach(message -> {
            MessageListResDto result = JSONObject.parseObject(JSON.toJSONString(message), MessageListResDto.class);
            resultList.add(result);
        });
        return resultList;
    }

    @Override
    public List<MessageListDetailResDto> getMessageListDetail(Integer sessionId) {
        List<MessageInfoPo> messageInfoList =
                messageInfoDao.selectBySessionAndStatus(sessionId, MessageStateEnum.RECEIVED.getCode());
        // 拼装消息
        List<MessageListDetailResDto> resultList = new ArrayList<>();
        messageInfoList.forEach(message -> {
            MessageListDetailResDto result = JSONObject.parseObject(JSON.toJSONString(message), MessageListDetailResDto.class);
            resultList.add(result);
        });
        return resultList;
    }
}
