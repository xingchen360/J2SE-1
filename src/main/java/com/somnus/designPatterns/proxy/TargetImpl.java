package com.somnus.designPatterns.proxy;

public class TargetImpl implements TargetInterface ,TargetInterface2{

	public void doSomething(String param) 
	{
		
		System.out.println("do something:"+param);
		
	}

	public void doSomething2()
	{
		System.out.println("do something2:xxoo");
	}

	

}
