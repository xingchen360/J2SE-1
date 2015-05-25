package com.somnus.accessModifier;

public class StringTest {
	
	public static void main(String[] args) {
		String str = "abcd";
		String str2 = "cd";
		System.out.println(str == "ab" + "cd");
		System.out.println(str == "ab" + str2);
	}
	
}