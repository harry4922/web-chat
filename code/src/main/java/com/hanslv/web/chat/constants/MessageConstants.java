package com.hanslv.web.chat.constants;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/5 15:25
 * @description 文字常量
 */
public class MessageConstants {
    /**
     * 注册成功
     */
    public static final String INFO_LOGON_SUCCESS = "注册成功";

    /**
     * 注册失败-当前用户名已存在
     */
    public static final String ERR_LOGON_EXIST_NAME = "注册失败，当前用户名已存在";

    /**
     * 登录成功
     */
    public static final String INFO_LOGIN_SUCCESS = "登录成功";

    /**
     * 登录失败-当前用户不存在
     */
    public static final String ERR_LOGIN_NOT_EXIST = "登录失败，当前用户不存在";

    /**
     * 登录失败-密码错误
     */
    public static final String ERR_LOGIN_PASS_WRONG = "登录失败，密码错误";
}
