package com.somnus.reflect.reflect;

import java.lang.reflect.Method;

public class DumpMethods
{

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws ClassNotFoundException
	{

		Class<?> clazz = Class.forName(args[0]);

		Method[] methods = clazz.getDeclaredMethods();

		for (Method method : methods)
		{

			System.out.println(method);

		}

	}

}
