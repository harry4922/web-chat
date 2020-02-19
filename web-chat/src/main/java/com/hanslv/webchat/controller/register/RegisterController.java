package com.hanslv.webchat.controller.register;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanslv.webchat.commons.HtmlLocations;
import com.hanslv.webchat.commons.dto.TabUser;
import com.hanslv.webchat.service.register.RegisterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 注册页控制器
 * 
 * -------------------------------------------------
 * 1、进入注册页面													public String toRegister()
 * 2、将用户信息存储数据库											public String doRegister(@RequestBody String userInfo)
 * -------------------------------------------------
 * @author hanslv
 *
 */
@Controller
@RequestMapping("/register")
@Api(value="注册接口" , tags="注册")
public class RegisterController {
	Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	static final String REGISTER_GOOD = "1";//注册成功
	static final String REGISTER_NO_GOOD = "2";//注册失败，系统异常
	static final String EXIST_REGISTER = "3";//当前用户名已存在
	
	
	@Autowired
	private RegisterService registerService;
	
	/**
	 * 1、进入注册页面
	 * @return
	 */
	@ApiOperation(value="进入注册页面" , notes="用户注册入口")
	@GetMapping("/toRegister")
	public String toRegister() {
		return HtmlLocations.REGISTER_PAGE;
	}
	
	/**
	 * 2、将用户信息存储数据库
	 * @param userInfo 用户信息，JSON
	 * @return
	 */
	@ApiOperation(value="将用户信息存入数据库" , notes="执行注册，传入参数为JSON字符串")
	@PostMapping("/doRegister")
	@ResponseBody
	public String doRegister(@RequestBody TabUser userInfo) {
		return registerService.doRegister(userInfo);
	}
}
