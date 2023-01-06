package com.hanslv.web.chat.mapper;

import com.hanslv.web.chat.entity.SessionInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/4 15:17
 * @description SessionInfo
 */
@Mapper
public interface SessionInfoMapper {

    /**
     * 获取全部会话信息
     * @return 会话信息列表
     */
    List<SessionInfoEntity> selectAll();

    /**
     * 根据用户ID查询Session
     * @param userId 当前用户ID
     * @param otherUserId 对方用户ID
     * @return Session
     */
    SessionInfoEntity selectByUserId(
            @Param("userId") Integer userId,
            @Param("otherUserId")Integer otherUserId);

    /**
     * 获取最大SessionID
     * @return 最大SessionID
     */
    Integer selectMaxSessionId();

    /**
     * 插入一条包含ID的记录
     * @param id ID
     * @param userId 用户ID
     * @param latestMessageId 最后消息ID
     */
    void insertOne(
            @Param("id")Integer id,
            @Param("userId")Integer userId,
            @Param("latestMessageId")Integer latestMessageId);


    /**
     * 更新session最后一条消息ID
     * @param sessionId sessionId
     * @param messageId 消息ID
     * @param userId 用户ID
     */
    void updateSessionMessageId(
            @Param("sessionId")Integer sessionId,
            @Param("messageId")Integer messageId,
            @Param("userId")Integer userId);

}
