package com.hanslv.web.chat.util;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/10 15:43
 * @description 字符串工具类
 */
public class StringUtils {

    /**
     * 判断字符串是否为空
     * @param str 字符串
     * @return 是否为空
     */
    public static boolean isEmpty(String str){
        if(str == null){
            return true;
        }
        String trimedStr = str.trim();
        return "".equals(trimedStr);
    }
}
