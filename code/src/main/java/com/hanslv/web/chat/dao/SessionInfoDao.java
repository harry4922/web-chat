package com.hanslv.web.chat.dao;

import com.hanslv.web.chat.entity.SessionInfoEntity;
import com.hanslv.web.chat.mapper.SessionInfoMapper;
import com.hanslv.web.chat.util.KeyUtil;
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

    /**
     * 获取全部会话信息
     * @return 会话信息列表
     */
    public List<SessionInfoEntity> selectAll(){
        return sessionInfoMapper.selectAll();
    }

    /**
     * 根据SessionKey获取会话
     * @param userId 发送方用户ID
     * @param receiveUserId 接收方用户ID
     * @return 会话信息
     */
    public SessionInfoEntity selectBySessionKey(Integer userId, Integer receiveUserId){
        String sessionKeyA = KeyUtil.getSessionKey(userId, receiveUserId);
        String sessionKeyB = KeyUtil.getSessionKey(receiveUserId, userId);
        return sessionInfoMapper.selectBySessionKey(sessionKeyA, sessionKeyB);
    }

    /**
     * 插入一条会话
     * @param userId 用户ID
     * @param receiveUserId 接收方用户ID
     * @return 会话ID
     */
    public Integer insertOne(Integer userId, Integer receiveUserId){
        String sessionKey = KeyUtil.getSessionKey(userId, receiveUserId);
        return sessionInfoMapper.insertOne(sessionKey);
    }
}
