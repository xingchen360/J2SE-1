package com.somnus.reflect.reflect;

import java.lang.reflect.Field;

public class PrivateProperty
{
	public static void main(String[] args) throws Exception
	{
		Private2 p2 = new Private2();
		
		Class<?> clazz = p2.getClass();
		
		Field field = clazz.getDeclaredField("name");
		
		field.setAccessible(true);
		
		field.set(p2, "jack");
		
		System.out.println(p2.gerName());

	}

}
class Private2
{
	private String name = "lucy";
	
	public String gerName()
	{
		return name;
	}
}
