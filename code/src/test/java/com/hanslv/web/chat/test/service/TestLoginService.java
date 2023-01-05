package com.hanslv.web.chat.test.service;

import com.hanslv.web.chat.dto.res.LoginResDto;
import com.hanslv.web.chat.dto.res.LogonResDto;
import com.hanslv.web.chat.services.LoginService;
import com.hanslv.web.chat.test.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/5 15:28
 * @description 登录注册测试
 */
@Slf4j
public class TestLoginService extends BaseTest {

    @Autowired
    private LoginService loginService;

    @Test
    public void testLogon(){
        String name = "Lucy";
        String pass = "Lucy";
        LogonResDto result = loginService.logon(name, pass);
        log.info(result.toString());
    }

    @Test
    public void testLogin(){
        String name = "Nala";
        String pass = "Nala";
        LoginResDto result = loginService.login(name, pass);
        log.info(result.toString());
    }
}
