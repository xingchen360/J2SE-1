package com.somnus.io;

import java.io.UnsupportedEncodingException;

/** 
 * @Title: EncodedDemo.java 
 * @Package com.somnus.io 
 * @Description: TODO
 * @author Somnus
 * @date 2015年5月17日 下午1:45:24 
 * @version V1.0 
 */
public class EncodedDemo {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "美丽ABC";
		//utf-8编码中文占用3个字节，英文占用1个字节
		byte[] buff = str.getBytes(/*"utf-8"*/);
		for(byte b:buff){
			System.out.print(Integer.toHexString(b & 0xff )+" ");
		}
		
		System.out.println();
		//gbk编码中文占用32个字节，英文占用1个字节
		byte[] buff2 = str.getBytes("gbk");
		for(byte b:buff2){
			System.out.print(Integer.toHexString(b & 0xff )+" ");
		}
	}

}
