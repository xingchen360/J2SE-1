package com.somnus.apache;

import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

public class CommonsCodec {
	public static void main(String[] args) throws Exception {
		Base64 base64 = new Base64();
		String encodestr = base64.encodeToString("Somnus".getBytes(/*"UTF-8"*/));
		System.out.println("Base64 编码后：" + encodestr);
		
		String decodestr = new String(Base64.decodeBase64("U29tbnVz"));  
        System.out.println("Base64 解码后："+decodestr);  
        
        /*%E7%BD%82(-25, -67, -126) %E7%B2%9F(-25, -78, -97) %E8%8A%B1(-24, -118, -7)*/
        byte[] buf = "Somnus罂粟花".getBytes(/*"utf-8"*/);
        System.out.println(Arrays.toString(buf));
        String byte2hex = Hex.encodeHexString(buf);
        System.out.println(byte2hex);
        byte[] hex2byte = Hex.decodeHex(byte2hex.toCharArray());
        System.out.println(Arrays.toString(hex2byte));
        System.out.println(new String(hex2byte));
	}
}
