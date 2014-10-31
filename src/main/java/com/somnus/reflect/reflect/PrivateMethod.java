package com.somnus.reflect.reflect;

import java.lang.reflect.Method;

public class PrivateMethod
{
	public static void main(String[] args) throws Exception
	{
		Private1 p1 = new Private1();
		
		Class<?> clazz = p1.getClass();
		
		Method method = clazz.getDeclaredMethod("say", new Class[]{String.class});
		
		method.setAccessible(true);
		
		String retu = (String)method.invoke(p1, new Object[]{"hello world"});
		
		System.out.println(retu);

	}

}
class Private1
{
	private String say(String param)
	{
		return param;
	}
}
