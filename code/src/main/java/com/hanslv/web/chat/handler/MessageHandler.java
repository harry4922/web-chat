package com.hanslv.web.chat.handler;

import com.hanslv.web.chat.dao.MessageInfoDao;
import com.hanslv.web.chat.entity.MessageInfoEntity;
import com.hanslv.web.chat.enums.MessageStateEnum;
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
     */
    public void handleNotPersistenceMessage(Integer sendUserId, Integer receiveUserId, String message){
        // 实体
        MessageInfoEntity messageInfoEntity = new MessageInfoEntity();
        messageInfoEntity.setUserId(sendUserId);
        messageInfoEntity.setReceiveUserId(receiveUserId);
        messageInfoEntity.setMessage(message);
        messageInfoEntity.setStatus(MessageStateEnum.NOT_RECEIVED.getCode());
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
}
