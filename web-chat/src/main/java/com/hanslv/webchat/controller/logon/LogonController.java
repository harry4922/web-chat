package com.hanslv.webchat.controller.logon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanslv.webchat.commons.HtmlLocations;
import com.hanslv.webchat.service.logon.LogonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 登录页控制器
 * ------------------------------------------------
 * 1、进入登录首页								public String logonMain()
 * 2、用户名密码校验								public String logonCheck(@RequestParam("username")String username , @RequestParam("pass")String pass)
 * ------------------------------------------------
 * @author hanslv
 *
 */
@Controller
@RequestMapping("/logon")
@Api(value="登录接口" , tags="登录")
public class LogonController {
	
	@Autowired
	private LogonService logonService;
	
	/**
	 * 1、进入登录首页
	 * @return
	 */
	@GetMapping("/")
	@ApiOperation(value="登录展示页面" , notes="用户登录入口")
	public String logonMain() {
		return HtmlLocations.LOGON_MAIN_PAGE;
	}
	
	/**
	 * 2、用户名密码校验
	 * @param username
	 * @param pass
	 * @return
	 */
	@PostMapping("/dologon")
	@ApiOperation(value="用户名密码check，返回验证信息")
	@ResponseBody
	public String logonCheck(@RequestParam("username")String username , @RequestParam("pass")String pass) {
		return logonService.checkLogon(username , pass);
	}
}
