package com.hanslv.web.chat.util;

import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/5 15:06
 * @description 密码Util
 */
public class PasswordUtil {
    /**
     * 加密处理
     * @param rawPassword 未加密密码
     * @return 加密后密码
     */
    public static String encode(String rawPassword) {
        // 加密过程
        // 1. 使用MD5算法
        // 2. 使用随机的盐值
        // 3. 循环5次
        // 4. 盐的处理方式为：盐 + 原密码 + 盐 + 原密码 + 盐
        // 注意：因为使用了随机盐，盐值必须被记录下来，本次的返回结果使用$分隔盐与密文
        String salt = UUID.randomUUID().toString().replace("-", "");
        String encodedPassword = rawPassword;
        for (int i = 0; i < 5; i++) {
            encodedPassword = DigestUtils.md5DigestAsHex(
                    (salt + encodedPassword + salt + encodedPassword + salt).getBytes());
        }
        return salt + encodedPassword;
    }

    /**
     * 密码匹配
     * @param rawPassword 未加密密码
     * @param encodedPassword 加密后密码
     * @return 匹配结果
     */
    public static boolean matches(String rawPassword, String encodedPassword) {
        String salt = encodedPassword.substring(0, 32);
        String newPassword = rawPassword;
        for (int i = 0; i < 5; i++) {
            newPassword = DigestUtils.md5DigestAsHex(
                    (salt + newPassword + salt + newPassword + salt).getBytes());
        }
        newPassword = salt + newPassword;
        return newPassword.equals(encodedPassword);
    }
}
