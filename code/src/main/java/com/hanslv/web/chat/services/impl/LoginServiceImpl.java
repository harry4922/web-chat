package com.hanslv.web.chat.services.impl;

import com.hanslv.web.chat.constants.MessageConstants;
import com.hanslv.web.chat.dao.UserInfoDao;
import com.hanslv.web.chat.dto.res.LoginResDto;
import com.hanslv.web.chat.dto.res.LogonResDto;
import com.hanslv.web.chat.entity.UserInfoEntity;
import com.hanslv.web.chat.handler.TokenHandler;
import com.hanslv.web.chat.services.LoginService;
import com.hanslv.web.chat.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : hansLv
 * @date : 2022/12/30 11:10
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private TokenHandler tokenHandler;

    @Override
    public LogonResDto logon(String name, String password) {
        // 注册结果
        LogonResDto result = new LogonResDto();
        // 判断当前用户名是否已存在
        UserInfoEntity userInfo = userInfoDao.selectByName(name);
        if(userInfo == null){
            userInfo = new UserInfoEntity();
            userInfo.setName(name);
            // 对密码进行加密
            userInfo.setPass(PasswordUtil.encode(password));
            userInfoDao.insertOne(userInfo);
            result.setLogonResult(true);
            result.setMessage(MessageConstants.INFO_LOGON_SUCCESS);
        }else{
            result.setLogonResult(false);
            result.setMessage(MessageConstants.ERR_LOGON_EXIST_NAME);
        }
        return result;
    }

    @Override
    public LoginResDto login(String name, String password) {
        // 登录结果
        LoginResDto result = new LoginResDto();
        // 判断当前用户名是否已存在
        UserInfoEntity userInfo = userInfoDao.selectByName(name);
        if(userInfo != null){
            // 校验密码
            if(PasswordUtil.matches(password, userInfo.getPass())){
                result.setResult(true);
                result.setMessage(MessageConstants.INFO_LOGIN_SUCCESS);
                result.setUserId(userInfo.getId());
                // 生成Token
                result.setToken(tokenHandler.initToken(userInfo.getId()));
            }else{
                result.setResult(false);
                result.setMessage(MessageConstants.ERR_LOGIN_PASS_WRONG);
            }
        }else{
            result.setResult(false);
            result.setMessage(MessageConstants.ERR_LOGIN_NOT_EXIST);
        }
        return result;
    }
}
