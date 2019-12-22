package com.hanslv.webchat.commons.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 密码的加密与解密
 * ---------------------------------------------------------------
 * 1、对传入的明文密码进行加密										public static String encryption(String pass)
 * ---------------------------------------------------------------
 * @author hanslv
 *
 */
public class PassUtil {
	private static final String HEXDIGITS[] = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
	/**
	 * 1、对传入的明文密码进行加密
	 * @param pass
	 * @return
	 */
	public static String encryption(String pass) {
		String encryptedPass = null;
		/*
		 * 获取MD5实例
		 */
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			
			/*
			 * 当传入的密码不为空则进行加密
			 */
			if(pass != null && !"".equals(pass)) encryptedPass = byteArrayToHexString(messageDigest.digest(pass.getBytes("UTF-8")));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encryptedPass;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    private static String byteArrayToHexString(byte b[]){
        StringBuffer resultSb = new StringBuffer();
        for(int i = 0; i < b.length; i++){
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }
    private static String byteToHexString(byte b){
        int n = b;
        if(n < 0){
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return HEXDIGITS[d1] + HEXDIGITS[d2];
    }
}
