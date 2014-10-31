package com.somnus;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class Test {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println(URLEncoder.encode("柳若","UTF-8"));
		System.out.println(URLDecoder.decode("%E4%B8%AD%E5%9B%BD","UTF-8"));
		
		System.out.println(URLEncoder.encode("柳","GBK"));
		System.out.println(URLDecoder.decode("%D6%D0%B9%FA","GBK"));

	}

}
