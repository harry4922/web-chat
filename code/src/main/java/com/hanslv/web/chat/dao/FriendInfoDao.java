package com.hanslv.web.chat.dao;

import com.hanslv.web.chat.entity.FriendInfoEntity;
import com.hanslv.web.chat.mapper.FriendInfoMapper;
import com.hanslv.web.chat.po.FriendInfoPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/9 10:13
 * @description FriendInfo
 */
@Repository
public class FriendInfoDao {

    @Autowired
    private FriendInfoMapper friendInfoMapper;

    /**
     * 获取全部信息
     * @return 全部好友信息
     */
    public List<FriendInfoEntity> selectAll(){
        return friendInfoMapper.selectAll();
    }

    /**
     * 插入一条好友信息
     * @param friendInfo 好友信息
     */
    public void insertOne(FriendInfoEntity friendInfo){
        friendInfoMapper.insertOne(friendInfo);
    }

    /**
     * 插入好友信息
     * @param userId 当前用户ID
     * @param friendUserId 好友用户ID
     */
    public void insertFriendInfo(Integer userId, Integer friendUserId){
        FriendInfoEntity currentUserFriendInfo = new FriendInfoEntity();
        currentUserFriendInfo.setUserId(userId);
        currentUserFriendInfo.setFriendUserId(friendUserId);
        FriendInfoEntity friendUserInfo = new FriendInfoEntity();
        friendUserInfo.setUserId(friendUserId);
        friendUserInfo.setFriendUserId(userId);
        insertOne(currentUserFriendInfo);
        insertOne(friendUserInfo);
    }

    /**
     * 获取好友列表
     * @param userId 当前用户ID
     * @return 好友列表
     */
    public List<FriendInfoPo> getFriendList(Integer userId){
        return friendInfoMapper.getFriendList(userId);
    }

    /**
     * 删除好友信息
     * @param userId 当前用户ID
     * @param friendUserId 好友信息
     */
    public void deleteFriendInfo(Integer userId, Integer friendUserId){
        friendInfoMapper.deleteFriendInfo(userId, friendUserId);
    }
}
