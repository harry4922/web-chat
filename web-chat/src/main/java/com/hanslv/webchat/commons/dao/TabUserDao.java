package com.hanslv.webchat.commons.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hanslv.webchat.commons.dto.TabUser;

/**
 * tab_user.DAO
 * ----------------------------------------------------------------
 * 1、根据用户名获取当前用户信息												public TabUser getUserByUsername(@Param("userName")String userName)
 * 2、更新当前用户登录状态													public void updateUserLogon(@Param("userId")Integer userId , @Param("isLogon")boolean isLogon)
 * ----------------------------------------------------------------
 * @author hanslv
 *
 */
@Mapper
public interface TabUserDao {
	/**
	 * 1、根据用户名获取当前用户信息
	 * @param userName
	 * @return
	 */
	@Select("SELECT user_id , user_name , user_real_name , user_mobel , user_mail , user_password , is_logon , role_id FROM tab_user WHERE user_name = #{userName}")
	public TabUser getUserByUsername(@Param("userName")String userName);
	
	/**
	 * 2、更新当前用户登录状态
	 * @param userId
	 * @param isLogon
	 */
	@Update("UPDATE tab_user SET is_logon = #{isLogon} WHERE user_id = #{userId}")
	public void updateUserLogon(@Param("userId")Integer userId , @Param("isLogon")boolean isLogon);
}
