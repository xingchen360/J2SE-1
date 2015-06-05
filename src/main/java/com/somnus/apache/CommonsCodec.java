package com.somnus.apache;

import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

public class CommonsCodec {
	public static void main(String[] args) throws Exception {
		String encode = Base64.encodeBase64String("Somnus".getBytes(/*"UTF-8"*/));
		System.out.println("Base64 编码后：" + encode);
		
		byte[] decode = Base64.decodeBase64("U29tbnVz");
		String decodestr = new String(decode);  
        System.out.println("Base64 解码后："+decodestr);  
        
        /*%E7%BD%82(-25, -67, -126) %E7%B2%9F(-25, -78, -97) %E8%8A%B1(-24, -118, -7)*/
        byte[] buff = "Somnus罂粟花".getBytes(/*"utf-8"*/);
        System.out.println(Arrays.toString(buff));
        String byte2hex = Hex.encodeHexString(buff);
        System.out.println(byte2hex);
        byte[] hex2byte = Hex.decodeHex(byte2hex.toCharArray());
        System.out.println(Arrays.toString(hex2byte));
        System.out.println(new String(hex2byte));
	}
}
