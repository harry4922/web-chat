package com.hanslv.web.chat.dao;

import com.hanslv.web.chat.entity.SessionInfoEntity;
import com.hanslv.web.chat.mapper.SessionInfoMapper;
import com.hanslv.web.chat.handler.CaffeineHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/4 15:18
 * @description SessionInfo
 */
@Repository
public class SessionInfoDao {

    @Autowired
    private SessionInfoMapper sessionInfoMapper;

    @Autowired
    private CaffeineHandler caffeineHandler;

    /**
     * 获取全部会话信息
     * @return 会话信息列表
     */
    public List<SessionInfoEntity> selectAll(){
        return sessionInfoMapper.selectAll();
    }


    /**
     * 根据用户ID查询会话
     * @param userId 用户ID
     * @param otherUserId 对方用户ID
     * @return 会话
     */
    public SessionInfoEntity selectByUserId(Integer userId, Integer otherUserId){
        return sessionInfoMapper.selectByUserId(userId, otherUserId);
    }

    /**
     * 获取当前最大SessionID
     * @return 最大SessionID
     */
    public int selectMaxSessionId(){
        Integer maxSessionId = sessionInfoMapper.selectMaxSessionId();
        if(maxSessionId == null){
            return 0;
        }
        return maxSessionId;
    }


    /**
     * 插入一条记录
     * @param userId 用户ID
     * @param otherUserId 对方用户ID
     * @param latestMessageId 最后一条消息ID
     * @return SessionID
     */
    public int insertSession(Integer userId, Integer otherUserId, Integer latestMessageId){
        // 获取当前Session序号
        int currentIndex = caffeineHandler.getNextSessionIndex();
        sessionInfoMapper.insertOne(currentIndex, userId, latestMessageId);
        sessionInfoMapper.insertOne(currentIndex, otherUserId, latestMessageId);
        return currentIndex;
    }

    /**
     * 更新Session最后消息ID
     * @param sessionId sessionId
     * @param messageId 消息Id
     * @param userId 当前用户ID
     * @param receiveUserId 接收用户ID
     */
    public void updateSessionMessageId(Integer sessionId, Integer messageId, Integer userId, Integer receiveUserId){
        sessionInfoMapper.updateSessionMessageId(sessionId, messageId, userId);
        sessionInfoMapper.updateSessionMessageId(sessionId, messageId, receiveUserId);
    }


}
