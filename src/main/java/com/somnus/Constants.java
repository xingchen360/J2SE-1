package com.somnus;

import java.net.URL;

public class Constants {
	public static final URL URL_ROOT = Constants.class.getResource("/");
	public static final String PATH_CLASS_ROOT = URL_ROOT.getPath();

	public static final String File_Path = PATH_CLASS_ROOT.substring(0,PATH_CLASS_ROOT.length() - 16);
	public static void main(String[] args) {
		System.out.println(URL_ROOT);
		System.out.println(PATH_CLASS_ROOT);
	}
}
