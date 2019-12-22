package com.hanslv.webchat.controller.logon;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hanslv.webchat.commons.HtmlLocations;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 登录页控制器
 * ------------------------------------------------
 * 1、进入登录首页								public String loginMain()
 * ------------------------------------------------
 * @author hanslv
 *
 */
@Controller
@RequestMapping("/logon")
@Api(value="登录接口" , tags="登录")
public class LogonController {
	
	/**
	 * 1、进入登录首页
	 * @return
	 */
	@GetMapping("/")
	@ApiOperation(value="登录展示页面" , notes="用户登录入口")
	public String loginMain() {
		return HtmlLocations.LOGON_MAIN_PAGE;
	}
}
