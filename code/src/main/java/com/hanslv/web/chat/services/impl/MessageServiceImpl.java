package com.hanslv.web.chat.services.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hanslv.web.chat.dao.MessageInfoDao;
import com.hanslv.web.chat.dto.res.MessageListResDto;
import com.hanslv.web.chat.dto.res.MessageDetailListResDto;
import com.hanslv.web.chat.enums.MessageStateEnum;
import com.hanslv.web.chat.po.MessageInfoPo;
import com.hanslv.web.chat.po.MessageListPo;
import com.hanslv.web.chat.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public MessageListResDto getMessageList(Integer userId) {
        // 获取消息列表
        List<MessageListPo> messageList = messageInfoDao.messageList(userId);
        // 结果
        MessageListResDto result = new MessageListResDto();
        // 拼装消息
        List<MessageListResDto.MessageListInfo> resultInfoList = result.getMessageInfoList();
        messageList.forEach(message -> {
            MessageListResDto.MessageListInfo currentResult =
                    JSONObject.parseObject(JSON.toJSONString(message), MessageListResDto.MessageListInfo.class);
            resultInfoList.add(currentResult);
        });
        return result;
    }

    @Override
    public MessageDetailListResDto getMessageListDetail(Integer sessionId) {
        List<MessageInfoPo> messageInfoList =
                messageInfoDao.selectBySessionAndStatus(sessionId, MessageStateEnum.RECEIVED.getCode());

        MessageDetailListResDto resData = new MessageDetailListResDto();
        // 拼装消息
        List<MessageDetailListResDto.MessageDetailInfo> resultList = resData.getMessageList();
        messageInfoList.forEach(message -> {
            MessageDetailListResDto.MessageDetailInfo result =
                    JSONObject.parseObject(JSON.toJSONString(message), MessageDetailListResDto.MessageDetailInfo.class);
            resultList.add(result);
        });
        return resData;
    }

    @Override
    public void updateMessageStatus(int status, List<Integer> messageIdList) {
        messageInfoDao.updateMultiMessageStatus(status, messageIdList);
    }
}
