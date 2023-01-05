package com.hanslv.web.chat.test.pass;

import com.hanslv.web.chat.util.PasswordUtil;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/5 15:07
 * @description
 */
public class PasswordTest {

    private static final String RAW_PASS = "abcd-1234";

    public static void main(String[] args) {
        String encodedPassword = PasswordUtil.encode(RAW_PASS);
        System.out.println("加密后密码：" + encodedPassword + "，对比结果：" + PasswordUtil.matches(RAW_PASS, encodedPassword));
    }
}
