package com.hanslv.webchat.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hanslv.webchat.commons.HtmlLocations;

/**
 * 登录页控制器
 * ------------------------------------------------
 * 
 * ------------------------------------------------
 * @author hanslv
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	
	/**
	 * 进入登录首页
	 * @return
	 */
	@GetMapping("/")
	public String loginMain() {
		return HtmlLocations.LOGIN_MAIN_PAGE;
	}
}
