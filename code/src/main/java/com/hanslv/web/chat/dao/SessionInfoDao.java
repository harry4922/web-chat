package com.hanslv.web.chat.dao;

import com.hanslv.web.chat.entity.SessionInfoEntity;
import com.hanslv.web.chat.mapper.SessionInfoMapper;
import com.hanslv.web.chat.util.CaffeineUtil;
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
    private CaffeineUtil caffeineUtil;

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
     * @return SessionID
     */
    public int insertSession(Integer userId, Integer otherUserId){
        // 获取当前Session序号
        int currentIndex = caffeineUtil.getNextSessionIndex();
        sessionInfoMapper.insertOne(currentIndex, userId);
        sessionInfoMapper.insertOne(currentIndex, otherUserId);
        return currentIndex;
    }


}
