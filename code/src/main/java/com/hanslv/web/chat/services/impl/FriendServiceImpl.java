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
    public void addFriendReq(Integer userId, Integer friendUserID) {
        FriendInfoEntity friendInfoEntity = new FriendInfoEntity();
        friendInfoEntity.setUserId(userId);
        friendInfoEntity.setFriendUserId(friendUserID);
        friendInfoEntity.setStatus(FriendStatusEnum.REQUEST.getCode());
    }
}
