package com.hanslv.web.chat.handler;

import com.alibaba.fastjson.JSON;
import com.hanslv.web.chat.dto.ChatMessageDTO;
import com.hanslv.web.chat.entity.MessageInfoEntity;
import com.hanslv.web.chat.enums.MessageStateEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : hansLv
 * @date : 2022/12/28 14:45
 * WebSocket处理器
 */
@Slf4j
@ServerEndpoint("/ws/chat/{userId}")
@Component
public class WebSocketHandler {

    /**
     * 连接池
     */
    private static Map<Integer, Session> sessionPool = new ConcurrentHashMap<>(8);

    /**
     * 消息持久化处理器
     */
    private static MessageHandler messageHandler;


    @Autowired
    public void init(MessageHandler messageHandler){
        WebSocketHandler.messageHandler = messageHandler;
    }


    /**
     * 创建连接
     * @param session 会话
     * @param userId 用户ID
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userId")Integer userId){
        // 将当前会话放入连接池
        sessionPool.put(userId, session);
        log.info(userId + "上线了");
        // 获取当前用户未读取的消息
        List<MessageInfoEntity> notReceivedMessageList =
                messageHandler.getMessageByStatus(userId, MessageStateEnum.NOT_RECEIVED.getCode());
        // 将未读消息发送给用户
        notReceivedMessageList.forEach(message -> {
            Integer messageId = message.getId();
            Integer sendUserId = message.getUserId();
            String messageInfo = message.getMessage();
            // 发送消息
            if(sendMessage(sendUserId, userId, messageInfo)){
                // 处理消息状态
                messageHandler.updateMessageStatus(messageId, MessageStateEnum.RECEIVED.getCode());
            }
        });
    }

    /**
     * 关闭连接
     * @param userId 用户ID
     */
    @OnClose
    public void onClose(@PathParam("userId")Integer userId){
        sessionPool.remove(userId);
        log.info(userId + "下线了");
    }

    /**
     * 收到消息
     * @param messageJson 消息JSON
     */
    @OnMessage
    public void onMessage(String messageJson){
        // 转换消息体
        ChatMessageDTO messageEntity = JSON.parseObject(messageJson, ChatMessageDTO.class);
        // 发送方
        Integer sendUserId = messageEntity.getUserId();
        // 接收方
        Integer receiveUserId = messageEntity.getToUserId();
        // 消息信息
        String message = messageEntity.getMessage();
        log.info("接收到：" + sendUserId + "，发送给：" + receiveUserId + "，的消息：" + message);
        // 发送消息
        sendMessage(sendUserId, receiveUserId, message);
    }

    /**
     * 错误处理
     * @param session 会话
     * @param throwable 异常对象
     */
    @OnError
    public void onError(Session session, Throwable throwable){

    }


    /**
     * 发送消息
     * @param sendUserId 发送用户ID
     * @param receiveUserId 接收用户ID
     * @param message 消息
     * @return 是否发送成功
     */
    private boolean sendMessage(Integer sendUserId, Integer receiveUserId, String message){
        // 判断接收用户是否在线
        if(sessionPool.containsKey(receiveUserId)){
            Session receiveUserSession = sessionPool.get(receiveUserId);
            // 发送消息
            try {
                receiveUserSession.getBasicRemote().sendText(message);
                return true;
            } catch (IOException e) {
                log.error("消息发送失败，发送方：" + sendUserId + "，接收方：" + receiveUserId + "，消息信息：" + message, e);
                // 发送异常则先将消息落库
                messageHandler.handleNotPersistenceMessage(sendUserId, receiveUserId, message);
            }
        }else{
            log.info("消息发送失败，对方不在线，发送方：" + sendUserId + "，接收方：" + receiveUserId + "，消息信息：" + message);
            // 将消息落库
            messageHandler.handleNotPersistenceMessage(sendUserId, receiveUserId, message);
        }
        return false;
    }
}
