package com.hanslv.webchat.commons.util;

/**
 * 分表逻辑的实现
 * 
 * -------------------------------------------------------
 * 
 * -------------------------------------------------------
 * @author hanslv
 *
 */
public class TableSelector {
	/**
	 * 1、根据版本号判断当前聊天信息应该存储在哪一张表
	 * @param versionNum
	 * @return 表名称的数字后缀
	 */
	public static String chatInfoTableSelect(String versionNum) {
		/*
		 * 获取版本号最后一位
		 */
		String lastNum = String.valueOf(versionNum.charAt(versionNum.length() - 1));
		
		return Integer.parseInt(lastNum) / 2 + 1 + "";
	}
}
