package com.hanslv.web.chat.handler;

import com.alibaba.fastjson.JSON;
import com.hanslv.web.chat.dto.websocket.MessageReqDto;
import com.hanslv.web.chat.enums.MessageStateEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : hansLv
 * @date : 2022/12/28 14:45
 * WebSocket处理器
 */
@Slf4j
@ServerEndpoint("/ws/chat/{userId}/{token}")
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

    /**
     * Token处理
     */
    private static TokenHandler tokenHandler;


    @Autowired
    public void init(MessageHandler messageHandler, TokenHandler tokenHandler){
        WebSocketHandler.messageHandler = messageHandler;
        WebSocketHandler.tokenHandler = tokenHandler;
    }


    /**
     * 创建连接
     * @param session 会话
     * @param userId 用户ID
     * @param token token
     */
    @OnOpen
    public void onOpen(
            Session session,
            @PathParam("userId")Integer userId,
            @PathParam("token")String token) throws IOException {
        // token校验
        if(!tokenHandler.tokenCheck(userId, token)){
            log.info("token校验不通过：userId" + userId);
            session.close(new CloseReason(CloseReason.CloseCodes.NO_STATUS_CODE, "认证不通过"));
            return;
        }
        // 将当前会话放入连接池
        sessionPool.put(userId, session);
        log.info(userId + "上线了");
    }

    /**
     * 关闭连接
     * @param userId 用户ID
     * @param token token
     */
    @OnClose
    public void onClose(@PathParam("userId")Integer userId, @PathParam("token")String token){
        // token校验
        if(!tokenHandler.tokenCheck(userId, token)){
            log.info("token校验不通过：userId" + userId);
            return;
        }
        sessionPool.remove(userId);
        log.info(userId + "下线了");
    }

    /**
     * 收到消息
     * @param userId 用户ID
     * @param token token
     * @param messageJson 消息JSON
     */
    @OnMessage
    public void onMessage(@PathParam("userId")Integer userId, @PathParam("token")String token, String messageJson){
        // token校验
        if(!tokenHandler.tokenCheck(userId, token)){
            log.info("token校验不通过：userId" + userId);
            return;
        }
        // 转换消息体
        MessageReqDto messageEntity = JSON.parseObject(messageJson, MessageReqDto.class);
        log.info("接收到：" + JSON.toJSONString(messageEntity));
        // 发送消息
        boolean sendResult = sendMessage(messageEntity);
        // 持久化消息
        if(sendResult){
            messageHandler.insertMessage(messageEntity, MessageStateEnum.RECEIVED.getCode());
        }
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
     * @param message 消息
     * @return 是否发送成功
     */
    private boolean sendMessage(MessageReqDto message){
        // 接收方
        Integer receiveUserId = message.getReceiveUserId();
        // 消息JSON
        String messageJson = JSON.toJSONString(message);
        // 判断接收用户是否在线
        if(sessionPool.containsKey(receiveUserId)){
            Session receiveUserSession = sessionPool.get(receiveUserId);
            // 发送消息
            try {
                receiveUserSession.getBasicRemote().sendText(messageJson);
                return true;
            } catch (IOException e) {
                log.error("消息发送失败，消息信息：" + JSON.toJSONString(message), e);
                // 发送异常则先将消息落库
                messageHandler.insertMessage(message, MessageStateEnum.NOT_RECEIVED.getCode());
            }
        }else{
            log.info("消息发送失败，对方不在线，消息信息：" + JSON.toJSONString(message));
            // 将消息落库
            messageHandler.insertMessage(message, MessageStateEnum.NOT_RECEIVED.getCode());
        }
        return false;
    }
}
