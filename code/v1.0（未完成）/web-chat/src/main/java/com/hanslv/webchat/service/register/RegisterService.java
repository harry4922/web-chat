package com.hanslv.webchat.service.register;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanslv.webchat.commons.dao.TabUserDao;
import com.hanslv.webchat.commons.dto.TabUser;
import com.hanslv.webchat.commons.util.PassUtil;

/**
 * 注册服务类
 * 
 * ---------------------------------------------------
 * 1、插入一条用户信息									public String doRegister(String userInfoJsonStr) throws Exception
 * ---------------------------------------------------
 * 
 * @author hanslv
 */
@Service
public class RegisterService {
	Logger logger = LoggerFactory.getLogger(RegisterService.class);
	
	static final String REGISTER_GOOD = "1";//注册成功
	static final String REGISTER_NO_GOOD = "2";//注册失败，系统异常
	static final String EXIST_REGISTER = "3";//当前用户名已存在
	
	@Autowired
	private TabUserDao userDao; 
	

	/**
	 * 1、插入一条用户信息
	 * @param userInfo
	 * @return 返回当前注册操作状态码 1=注册成功;2=注册失败，系统异常;3=当前用户名已存在
	 */
	public String doRegister(TabUser userInfo) {
		TabUser user = new TabUser();
		user.setUserName(userInfo.getUserName());
		user.setUserPassword(PassUtil.encryption(userInfo.getUserPassword()));
		user.setUserRealName(userInfo.getUserRealName());
		user.setUserMobel(userInfo.getUserMobel());
		user.setUserMail(userInfo.getUserMail());
		
		/*
		 * 判断当前用户名是否已存在
		 */
		TabUser existUser = userDao.getUserByUsername(userInfo.getUserName());
		if(existUser != null) return EXIST_REGISTER;
		
		/*
		 * 将信息插入数据库
		 */
		try {
			userDao.insertOne(user);
		}catch(Exception e) {
			logger.error("当前用户注册失败，数据库插入错误：" + user , e.getMessage() , e);
			return REGISTER_NO_GOOD;
		}
		
		logger.info("RegisterService 已插入用户注册信息：" + user);
		return REGISTER_GOOD;
	}
}
