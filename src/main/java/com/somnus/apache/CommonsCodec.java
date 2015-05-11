package com.somnus.apache;

import org.apache.commons.codec.binary.Base64;

public class CommonsCodec {
	public static void main(String[] args) throws Exception {
		Base64 base64 = new Base64();
		String encodestr = base64.encodeToString("abcd".getBytes(/*"UTF-8"*/));
		System.out.println("Base64 编码后：" + encodestr);
		
		String decodestr = new String(Base64.decodeBase64("YWJjZA=="));  
        System.out.println("Base64 解码后："+decodestr);  
	}
}
