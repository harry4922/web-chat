package com.hanslv.web.chat.services;

import com.hanslv.web.chat.dto.res.FriendListResDto;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/9 13:37
 * @description 好友服务类
 */
public interface FriendService {

    /**
     * 获取当前用户的好友列表
     * @param userId 用户ID
     * @return 好友列表
     */
    FriendListResDto getFriendList(Integer userId);

    /**
     * 添加好友请求
     * @param userId 当前用户ID
     * @param friendUserID 好友用户ID
     */
    void addFriendReq(Integer userId, Integer friendUserID);

    /**
     * 确认好友关系
     * @param userId 用户ID
     * @param friendUserId 好友用户ID
     */
    void confirmFriendReq(Integer userId, Integer friendUserId);
}
