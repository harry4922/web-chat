package com.hanslv.web.chat.handler;

import com.hanslv.web.chat.dao.MessageInfoDao;
import com.hanslv.web.chat.dao.SessionInfoDao;
import com.hanslv.web.chat.dto.req.MessageReqDto;
import com.hanslv.web.chat.entity.MessageInfoEntity;
import com.hanslv.web.chat.entity.SessionInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/3 15:35
 * @description 消息处理器
 */
@Component
public class MessageHandler {

    @Autowired
    private MessageInfoDao messageInfoDao;

    @Autowired
    private SessionInfoDao sessionInfoDao;

    /**
     * 获取对应状态的消息
     * @param userId 用户ID
     * @param status 状态
     * @return 未读消息
     */
    public List<MessageInfoEntity> getMessageByStatus(Integer userId, Integer status){
        return messageInfoDao.selectByUserIdAndStatus(userId, status);
    }

    /**
     * 处理待持久化消息
     * @param message 消息
     * @param status 消息状态
     */
    public void insertMessage(MessageReqDto message, int status){
        Integer sendUserId = message.getUserId();
        Integer receiveUserId = message.getReceiveUserId();
        String messageStr = message.getMessage();
        // 会话ID
        Integer sessionId = getSessionId(sendUserId, receiveUserId);
        // 实体
        MessageInfoEntity messageInfoEntity = new MessageInfoEntity();
        messageInfoEntity.setSessionId(sessionId);
        messageInfoEntity.setUserId(sendUserId);
        messageInfoEntity.setReceiveUserId(receiveUserId);
        messageInfoEntity.setMessage(messageStr);
        messageInfoEntity.setStatus(status);
        // 消息数据
        int currentMessageId = messageInfoDao.insertOne(messageInfoEntity);
        // 更新Session数据
        sessionInfoDao.updateSessionMessageId(sessionId, currentMessageId, sendUserId, receiveUserId);
    }

    /**
     * 更新消息状态
     * @param messageId 消息ID
     * @param status 状态
     */
    public void updateMessageStatus(Integer messageId, Integer status){
        messageInfoDao.updateMessageStatus(messageId, status);
    }

    /**
     * 获取SessionId
     * @param userId 用户ID
     * @param otherUserId 对方用户ID
     * @return SessionID
     */
    public int getSessionId(Integer userId, Integer otherUserId){
        SessionInfoEntity existSessionInfo = sessionInfoDao.selectByUserId(userId, otherUserId);
        Integer sessionId;
        if(existSessionInfo == null){
            // 新建会话
            sessionId = sessionInfoDao.insertSession(userId, otherUserId, 0);
        }else{
            sessionId = existSessionInfo.getId();
        }
        return sessionId;
    }
}
