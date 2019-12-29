package com.hanslv.webchat.service.logon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanslv.webchat.commons.Constants;
import com.hanslv.webchat.commons.dao.TabUserDao;
import com.hanslv.webchat.commons.dto.TabUser;
import com.hanslv.webchat.commons.util.PassUtil;

/**
 * 登录服务类
 * @author hanslv
 *
 */
@Service
public class LogonService {
	private static final String USER_NOT_EXIST = "当前用户不存在";
	private static final String WRONG_PASSWORD = "用户名密码错误";
	
	@Autowired
	private TabUserDao userDao;
	
	/**
	 * 1、验证密码是否正确
	 * @param user
	 * @return
	 */
	public String checkLogon(String username , String pass) {
		TabUser checkInfo = userDao.getUserByUsername(username);
		if(checkInfo != null) {
			if(checkInfo.getUserPassword().equals(PassUtil.encryption(pass))) {
				/*
				 * 记录用户登录状态
				 */
				userDao.updateUserLogon(checkInfo.getUserId() , true);
				return Constants.SUCCESS;
			}
			else return WRONG_PASSWORD;
		}
		return USER_NOT_EXIST;
	}
}
