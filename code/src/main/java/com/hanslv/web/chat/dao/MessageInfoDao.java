package com.hanslv.web.chat.dao;

import com.hanslv.web.chat.entity.MessageInfoEntity;
import com.hanslv.web.chat.mapper.MessageInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/3 13:34
 * @description Message_Info
 */
@Repository
public class MessageInfoDao {
    @Autowired
    private MessageInfoMapper messageInfoMapper;

    /**
     * 获取全部消息信息
     * @return 消息信息实体
     */
    public List<MessageInfoEntity> selectAll(){
        return messageInfoMapper.selectAll();
    }

    /**
     * 获取当前用户未读取消息
     * @param receiveUserId 接收方用户ID
     * @return 未读取消息
     */
    public List<MessageInfoEntity> selectByUserIdAndNotReceived(Integer receiveUserId){
        return messageInfoMapper.selectByUserIdAndNotReceived(receiveUserId);
    }

    /**
     * 插入单条消息
     * @param messageInfo 消息实体
     */
    public void insertOne(MessageInfoEntity messageInfo){
        messageInfoMapper.insertOne(messageInfo);
    }

    /**
     * 批量插入
     * @param messageInfoList 消息实体List
     */
    public void insertBatch(List<MessageInfoEntity> messageInfoList){
        if(!messageInfoList.isEmpty()){
            messageInfoMapper.insertBatch(messageInfoList);
        }
    }

    /**
     * 将消息更新为已读
     * @param messageId 消息ID
     */
    public void updateMessageReceived(Integer messageId){
        messageInfoMapper.updateMessageReceived(messageId);
    }
}
