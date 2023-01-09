package com.hanslv.web.chat.controllers;

import com.hanslv.web.chat.dto.req.FriendAddReqDto;
import com.hanslv.web.chat.dto.req.FriendConfirmReqDto;
import com.hanslv.web.chat.dto.req.FriendListReqDto;
import com.hanslv.web.chat.dto.res.FriendListResDto;
import com.hanslv.web.chat.interfaces.TokenCheck;
import com.hanslv.web.chat.services.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/9 15:17
 * @description 好友关系处理器
 */
@RequestMapping("/friend")
@RestController
public class FriendController {

    @Autowired
    private FriendService friendService;

    /**
     * 获取好友列表信息
     * @param reqDto 请求对象
     * @return 好友列表
     */
    @TokenCheck
    @PostMapping("/list")
    public FriendListResDto getFriendList(FriendListReqDto reqDto){
        return friendService.getFriendList(reqDto.getUserId());
    }

    /**
     * 请求添加好友
     * @param reqDto 请求对象
     */
    @TokenCheck
    @PostMapping("/add")
    public void addFriendReq(FriendAddReqDto reqDto){
        friendService.addFriendReq(reqDto.getUserId(), reqDto.getFriendUserId());
    }

    /**
     * 确认好友请求
     * @param reqDto 请求对象
     */
    @TokenCheck
    @PostMapping("/confirm")
    public void friendConfirm(FriendConfirmReqDto reqDto){
        friendService.confirmFriendReq(reqDto.getUserId(), reqDto.getFriendUserId());
    }

}
