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
     * 插入一条记录
     * @param userId 用户ID
     */
    int insertOne(
            @Param("userId")Integer userId);

    /**
     * 插入一条包含ID的记录
     * @param id ID
     * @param userId 用户ID
     */
    void insertOneWithId(
            @Param("id")Integer id,
            @Param("userId")Integer userId);

}
