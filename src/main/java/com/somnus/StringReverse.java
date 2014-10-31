package com.somnus;

public class StringReverse {

	// 反转1
	public static String reverse1(String s) 
	{
		char[] array = s.toCharArray();
		String reverse = "";
		for (int i = array.length - 1; i >= 0; i--) 
		{
			reverse += array[i];
		}
		return reverse;
	}

	// 反转2
	public static String reverse2(String s) 
	{
		return new StringBuffer(s).reverse().toString();
	}
	
	public static void main(String[] args) {
		System.out.println(reverse1(" I love java"));
		System.out.println(reverse1(" I love java"));
	}
}
