package com.hanslv.web.chat.mapper;

import com.hanslv.web.chat.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/3 13:28
 * @description UserInfo
 */
@Mapper
public interface UserInfoMapper {
    /**
     * 获取全部
     * @return 用户信息
     */
    List<UserInfoEntity> selectAll();

    /**
     * 插入一条用户信息
     * @param userInfo 用户信息
     */
    void insertOne(@Param("userInfo") UserInfoEntity userInfo);

    /**
     * 插入多条
     * @param userInfoList 用户信息List
     */
    void insertBatch(@Param("userInfoList") List<UserInfoEntity> userInfoList);

    /**
     * 根据ID删除一条记录
     * @param id ID
     */
    void deleteById(@Param("id")Integer id);
}
