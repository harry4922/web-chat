package com.hanslv.web.chat.services.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hanslv.web.chat.dao.FriendInfoDao;
import com.hanslv.web.chat.dto.res.FriendListResDto;
import com.hanslv.web.chat.entity.FriendInfoEntity;
import com.hanslv.web.chat.enums.FriendStatusEnum;
import com.hanslv.web.chat.po.FriendInfoPo;
import com.hanslv.web.chat.services.FriendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/9 13:38
 * @description 好友服务类
 */
@Slf4j
@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    private FriendInfoDao friendInfoDao;

    @Override
    public FriendListResDto getFriendList(Integer userId) {
        // 查询
        List<FriendInfoPo> friendInfoPoList = friendInfoDao.getFriendList(userId);
        // 拼装
        FriendListResDto resDto = new FriendListResDto();
        List<FriendListResDto.FriendListInfo> resultList = resDto.getFriendInfoList();
        friendInfoPoList.forEach(info ->
                resultList.add(JSONObject.parseObject(JSON.toJSONString(info), FriendListResDto.FriendListInfo.class)));
        return resDto;
    }

    @Override
    public void addFriendReq(Integer userId, Integer friendUserId) {
        FriendInfoEntity friendInfoEntity = new FriendInfoEntity();
        friendInfoEntity.setUserId(userId);
        friendInfoEntity.setFriendUserId(friendUserId);
        friendInfoEntity.setStatus(FriendStatusEnum.REQUEST.getCode());
    }

    @Override
    public void confirmFriendReq(Integer userId, Integer friendUserId) {
        // 更新好友信息状态，当前用户为库中对方好友用户ID
        friendInfoDao.updateFriendStatus(friendUserId, userId, FriendStatusEnum.CONFIRM.getCode());
        // 新建当前用户好友信息
        FriendInfoEntity friendInfoEntity = new FriendInfoEntity();
        friendInfoEntity.setUserId(userId);
        friendInfoEntity.setFriendUserId(friendUserId);
        friendInfoEntity.setStatus(FriendStatusEnum.CONFIRM.getCode());
        friendInfoDao.insertOne(friendInfoEntity);
    }

    @Override
    public void deleteFriend(Integer userId, Integer friendUserId) {
        // 删除当前用户好友记录
        friendInfoDao.deleteFriendInfo(userId, friendUserId);
        // 修改对方好友状态
        friendInfoDao.updateFriendStatus(friendUserId, userId, FriendStatusEnum.FRIEND_DELETE.getCode());
    }
}
