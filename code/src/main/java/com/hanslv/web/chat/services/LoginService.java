package com.hanslv.web.chat.services;

import com.hanslv.web.chat.dto.res.LoginResDto;
import com.hanslv.web.chat.dto.res.LogonResDto;

/**
 * @author : hansLv
 * @date : 2022/12/30 11:10
 * 登录注册服务类
 */
public interface LoginService {

    /**
     * 注册用户
     * @param name 用户名
     * @param password 密码
     * @return 注册结果
     */
    LogonResDto logon(String name, String password);


    /**
     * 登录验证
     * @param name 用户名
     * @param password 密码
     * @return 登录结果
     */
    LoginResDto login(String name, String password);

}
