package com.hanslv.web.chat.controllers;

import com.hanslv.web.chat.dto.req.LoginReqDto;
import com.hanslv.web.chat.dto.req.LogonReqDto;
import com.hanslv.web.chat.dto.res.LoginResDto;
import com.hanslv.web.chat.dto.res.LogonResDto;
import com.hanslv.web.chat.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/5 15:01
 * @description 注册控制器
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 注册
     * @param reqDto 请求对象
     * @return 注册结果
     */
    @PostMapping("/logon")
    public LogonResDto logon(@RequestBody LogonReqDto reqDto){
        return loginService.logon(reqDto.getUserName(), reqDto.getPassword());
    }

    /**
     * 登录
     * @param reqDto 请求对象
     * @return 登录结果
     */
    @PostMapping("/login")
    public LoginResDto login(@RequestBody LoginReqDto reqDto){
        return loginService.login(reqDto.getName(), reqDto.getPassword());
    }

}