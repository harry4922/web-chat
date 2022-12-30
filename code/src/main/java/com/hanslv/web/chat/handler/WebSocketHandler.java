package com.hanslv.web.chat.handler;

import com.alibaba.fastjson.JSON;
import com.hanslv.web.chat.entity.ChatMessageEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
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
    private Map<String, Session> sessionPool = new ConcurrentHashMap<>(8);

    /**
     * 创建连接
     * @param session 会话
     * @param userId 用户ID
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userId")String userId){
        // 将当前会话放入连接池
        sessionPool.put(userId, session);
        log.info(userId + "上线了");
    }

    /**
     * 关闭连接
     * @param userId 用户ID
     */
    @OnClose
    public void onClose(@PathParam("userId")String userId){
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
        ChatMessageEntity messageEntity = JSON.parseObject(messageJson, ChatMessageEntity.class);
        // 发送方
        String sendUserId = messageEntity.getUserId();
        // 接收方
        String receiveUserId = messageEntity.getToUserId();
        // 消息信息
        String message = messageEntity.getMessage();
        log.info("接收到：" + sendUserId + "，发送给：" + receiveUserId + "，的消息：" + message);
    }

    /**
     * 错误处理
     * @param session 会话
     * @param throwable 异常对象
     */
    @OnError
    public void onError(Session session, Throwable throwable){

    }
}
