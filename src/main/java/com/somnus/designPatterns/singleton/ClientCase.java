package com.somnus.designPatterns.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang.SerializationUtils;

public class ClientCase {
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Singleton s = Singleton.getInstance();
		Singleton s_ = Singleton.getInstance();
		System.out.println(s);
		System.out.println(s_);
		
		//通过反射破解
		Class<Singleton> clazz = (Class<Singleton>) Class.forName("com.somnus.designPatterns.singleton.Singleton");
		Constructor<Singleton> c = clazz.getDeclaredConstructor(null);
		c.setAccessible(true);
		Singleton s1 = c.newInstance();
		Singleton s2 = c.newInstance();
		System.out.println(s1 == s2);
		
		//通过序列化/反序列化破解
		Singleton s3 = (Singleton) SerializationUtils.clone(s);
		System.out.println(s3);
	}

}
