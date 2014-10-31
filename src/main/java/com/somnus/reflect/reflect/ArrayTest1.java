package com.somnus.reflect.reflect;

import java.lang.reflect.Array;

public class ArrayTest1 
{
	public static void main(String[] args) throws Exception 
	{
		Class classType = Class.forName("java.lang.String");
		
		//创建一个具有指定的组件类型和长度的新数组
		Object array = Array.newInstance(classType, 10);
		
		//将指定数组对象中索引组件的值设置为指定的新值
		Array.set(array, 5, "helloworld");
		
		//返回指定数组对象中索引组件的值
		String str = (String)Array.get(array, 5);
		
		System.out.println(str);
	}

}
