package com.hanslv.web.chat.test.dao;

import com.hanslv.web.chat.dao.UserInfoDao;
import com.hanslv.web.chat.entity.UserInfoEntity;
import com.hanslv.web.chat.test.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/3 13:37
 * @description 测试用户信息DAO
 */
@Slf4j
public class TestUserInfoDao extends BaseTest {

    @Autowired
    private UserInfoDao userInfoDao;

    @Test
    public void testSelectAll(){
        List<UserInfoEntity> userInfoList = userInfoDao.selectAll();
        userInfoList.forEach(userInfo -> log.info(userInfo.toString()));
    }

    @Test
    public void testInsert(){
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setName("Hans");
        userInfoEntity.setPass("123456");
        userInfoDao.insertOne(userInfoEntity);
    }

    @Test
    public void testInsertBatch(){
        UserInfoEntity userInfoEntityA = new UserInfoEntity();
        userInfoEntityA.setName("Hans");
        userInfoEntityA.setPass("123456");

        UserInfoEntity userInfoEntityB = new UserInfoEntity();
        userInfoEntityB.setName("Nala");
        userInfoEntityB.setPass("123456");

        List<UserInfoEntity> userInfoList = new ArrayList<>();
        userInfoList.add(userInfoEntityA);
        userInfoList.add(userInfoEntityB);

        userInfoDao.insertBatch(userInfoList);
    }

    @Test
    public void testDeleteById(){
        userInfoDao.deleteById(1);
    }

}
