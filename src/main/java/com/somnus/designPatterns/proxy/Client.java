package com.somnus.designPatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//根据一个目标类产生一个代理对象【也是实现该对象接的类，直接在JVM中被生成不用定义】
public class Client {

	public static void main(String[] args) 
	{
		final TargetInterface target = new TargetImpl();
		/*
		 * 目标类的加载器
		 * 目标实现的接口集合
		 * 代理类的调用处理程序对象
		 */
		TargetInterface proxy = (TargetInterface)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler(){
			public Object invoke(Object proxy, Method method, Object[] args)throws Throwable 
			{
				Object result = null;
				
				System.out.println("before calling: "+method);
				
				result = method.invoke(target, args);
				
				System.out.println("after calling: "+method);
				
				return result;
			}
		});
		proxy.doSomething("hello");
		System.out.println(proxy.getClass());
		
		
		
		final TargetInterface2 target2 = new TargetImpl();
		TargetInterface2 proxy2 = (TargetInterface2)Proxy.newProxyInstance(target2.getClass().getClassLoader(), target2.getClass().getInterfaces(), new InvocationHandler(){
			public Object invoke(Object proxy, Method method, Object[] args)throws Throwable 
			{
				Object result = null;
				
				System.out.println("before calling: "+method);
				
				result = method.invoke(target2, args);
				
				System.out.println("after calling: "+method);
				
				return result;
			}
		});
		proxy2.doSomething2();
		System.out.println(proxy2.getClass().getInterfaces());
	}

}
