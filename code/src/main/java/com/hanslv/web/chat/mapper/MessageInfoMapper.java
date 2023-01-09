package com.hanslv.web.chat.mapper;

import com.hanslv.web.chat.entity.MessageInfoEntity;
import com.hanslv.web.chat.po.MessageInfoPo;
import com.hanslv.web.chat.po.MessageListPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/3 13:34
 * @description MessageInfo
 */
@Mapper
public interface MessageInfoMapper {
    /**
     * 获取全部消息信息
     * @return 消息信息实体
     */
    List<MessageInfoEntity> selectAll();

    /**
     * 获取当前用户未读取消息
     * @param receiveUserId 接收方用户ID
     * @param status 消息状态
     * @return 指定状态的消息
     */
    List<MessageInfoEntity> selectByUserIdAndStatus(
            @Param("receiveUserId") Integer receiveUserId,
            @Param("status")int status);

    /**
     * 获取当前Session的聊天信息
     * @param sessionId sessionId
     * @param status 消息状态
     * @return 聊天信息
     */
    List<MessageInfoPo> selectBySessionAndStatus(
            @Param("sessionId")Integer sessionId,
            @Param("status")int status);

    /**
     * 插入单条
     * @param messageInfo 消息信息
     */
    void insertOne(@Param("messageInfo") MessageInfoEntity messageInfo);

    /**
     * 批量插入
     * @param messageInfoList 消息List
     */
    void insertBatch(@Param("messageInfoList") List<MessageInfoEntity> messageInfoList);

    /**
     *
     * @param messageId 消息ID
     * @param status 消息状态
     */
    void updateMessageStatus(
            @Param("messageId")Integer messageId,
            @Param("status")Integer status);

    /**
     * 获取消息列表
     * @param userId 用户ID
     * @return 消息列表信息
     */
    List<MessageListPo> messageList(
            @Param("userId")Integer userId);
}
