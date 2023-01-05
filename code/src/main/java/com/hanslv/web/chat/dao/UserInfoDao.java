package com.hanslv.web.chat.dao;

import com.hanslv.web.chat.entity.UserInfoEntity;
import com.hanslv.web.chat.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/3 13:29
 * @description UserInfo
 */
@Repository
public class UserInfoDao {
    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 获取全部用户信息
     * @return 用户信息列表
     */
    public List<UserInfoEntity> selectAll(){
        return userInfoMapper.selectAll();
    }

    /**
     * 根据用户名获取用户信息
     * @param name 用户名
     * @return 用户信息
     */
    public UserInfoEntity selectByName(String name){
        return userInfoMapper.selectByName(name);
    }

    /**
     * 插入一条用户信息
     * @param userInfo 用户信息实体
     */
    public void insertOne(UserInfoEntity userInfo){
        userInfoMapper.insertOne(userInfo);
    }

    /**
     * 插入多条用户信息
     * @param userInfoList 用户信息List
     */
    public void insertBatch(List<UserInfoEntity> userInfoList){
        if(!userInfoList.isEmpty()){
            userInfoMapper.insertBatch(userInfoList);
        }
    }

    /**
     * 根据ID删除一条用户信息
     * @param id ID
     */
    public void deleteById(Integer id){
        userInfoMapper.deleteById(id);
    }
}
