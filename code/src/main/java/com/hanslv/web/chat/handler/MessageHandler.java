package com.hanslv.web.chat.handler;

import com.hanslv.web.chat.dao.MessageInfoDao;
import com.hanslv.web.chat.dao.SessionInfoDao;
import com.hanslv.web.chat.entity.MessageInfoEntity;
import com.hanslv.web.chat.entity.SessionInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/3 15:35
 * @description 消息处理器
 */
@Component
public class MessageHandler {

    /**
     * 待持久化消息池
     */
    @Qualifier("NPP")
    @Autowired
    private List<MessageInfoEntity> npp;

    /**
     * 备用待持久化消息池
     */
    @Qualifier("NPPB")
    @Autowired
    private List<MessageInfoEntity> nppb;

    /**
     * 是否使用备用待持久化消息池
     */
    @Qualifier("NPPBFlag")
    @Autowired
    private AtomicBoolean nppbFlag;

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
     * @param sendUserId 发送用户ID
     * @param receiveUserId 接收用户ID
     * @param message 消息
     * @param status 消息状态
     */
    public void insertMessage(Integer sendUserId, Integer receiveUserId, String message, int status){
        // 会话ID
        Integer sessionId = getSessionId(sendUserId, receiveUserId);
        // 实体
        MessageInfoEntity messageInfoEntity = new MessageInfoEntity();
        messageInfoEntity.setSessionId(sessionId);
        messageInfoEntity.setUserId(sendUserId);
        messageInfoEntity.setReceiveUserId(receiveUserId);
        messageInfoEntity.setMessage(message);
        messageInfoEntity.setStatus(status);
        // 存入待持久化池
        if (nppbFlag.get()) {
            nppb.add(messageInfoEntity);
        } else {
            npp.add(messageInfoEntity);
        }
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
            sessionId = sessionInfoDao.insertSession(userId, otherUserId);
        }else{
            sessionId = existSessionInfo.getId();
        }
        return sessionId;
    }
}
