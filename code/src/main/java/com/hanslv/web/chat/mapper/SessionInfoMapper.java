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
     * 根据SessionKey获取
     * @param sessionKeyA 正向SessionKey
     * @param sessionKeyB 反向SessionKey
     * @return 会话信息
     */
    SessionInfoEntity selectBySessionKey(
            @Param("sessionKeyA")String sessionKeyA,
            @Param("sessionKeyB")String sessionKeyB);

    /**
     * 插入一条数据并返回ID
     * @param sessionKey 会话KEY
     * @return 当前会话ID
     */
    Integer insertOne(
            @Param("sessionKey")String sessionKey);
}
