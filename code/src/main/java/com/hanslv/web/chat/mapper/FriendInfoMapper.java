package com.hanslv.web.chat.mapper;

import com.hanslv.web.chat.entity.FriendInfoEntity;
import com.hanslv.web.chat.po.FriendInfoPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/9 10:13
 * @description FriendInfo
 */
@Mapper
public interface FriendInfoMapper {
    /**
     * 获取全部信息
     * @return 全部好友信息
     */
    List<FriendInfoEntity> selectAll();

    /**
     * 插入一条信息
     * @param friendInfo 好友信息
     */
    void insertOne(@Param("friendInfo") FriendInfoEntity friendInfo);

    /**
     * 获取好友列表
     * @param userId 用户ID
     * @return 好友列表
     */
    List<FriendInfoPo> getFriendList(
            @Param("userId") Integer userId);

    /**
     * 删除好友信息
     * @param userId 用户ID
     * @param friendUserId 好友用户ID
     */
    void deleteFriendInfo(
            @Param("userId") Integer userId,
            @Param("friendUserId") Integer friendUserId);
}
