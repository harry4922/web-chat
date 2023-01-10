package com.hanslv.web.chat.controllers;

import com.hanslv.web.chat.dto.req.FriendAddReqDto;
import com.hanslv.web.chat.dto.req.FriendConfirmReqDto;
import com.hanslv.web.chat.dto.req.FriendDeleteReqDto;
import com.hanslv.web.chat.dto.req.FriendListReqDto;
import com.hanslv.web.chat.dto.res.FriendListResDto;
import com.hanslv.web.chat.interfaces.TokenCheck;
import com.hanslv.web.chat.services.FriendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "好友接口", tags = {"好友接口"})
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
    @ApiOperation("获取好友列表")
    @TokenCheck
    @PostMapping("/list")
    public FriendListResDto getFriendList(FriendListReqDto reqDto){
        return friendService.getFriendList(reqDto.getUserId());
    }

    /**
     * 请求添加好友
     * @param reqDto 请求对象
     */
    @ApiOperation("添加好友请求")
    @TokenCheck
    @PostMapping("/add")
    public void addFriendReq(FriendAddReqDto reqDto){
        friendService.addFriendReq(reqDto.getUserId(), reqDto.getFriendUserId());
    }

    /**
     * 确认好友请求
     * @param reqDto 请求对象
     */
    @ApiOperation("添加好友确认")
    @TokenCheck
    @PostMapping("/confirm")
    public void friendConfirm(FriendConfirmReqDto reqDto){
        friendService.confirmFriendReq(reqDto.getUserId(), reqDto.getFriendUserId());
    }

    /**
     * 删除好友
     * @param reqDto 请求对象
     */
    @ApiOperation("删除好友")
    @TokenCheck
    @PostMapping("/delete")
    public void friendDelete(FriendDeleteReqDto reqDto){
        friendService.deleteFriend(reqDto.getUserId(), reqDto.getFriendUserId());
    }

}
