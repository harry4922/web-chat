package com.hanslv.webchat.commons.dao;

import com.hanslv.webchat.commons.dto.TabUser;

/**
 * tab_user.DAO
 * ----------------------------------------------------------------
 * 1、根据用户名获取当前用户信息												public TabUser getUserByUsername(@Param("userName")String userName)
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
	@Select("SELECT user_id , user_name , user_real_name , user_mobel , user_mail , user_password , is_logon , rule_id WHERE user_name = #{userName}")
	public TabUser getUserByUsername(@Param("userName")String userName);
}
