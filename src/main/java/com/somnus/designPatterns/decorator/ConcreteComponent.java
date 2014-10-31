package com.somnus.designPatterns.decorator;
/*
 * 具体构建角色
 */
public class ConcreteComponent implements Component
{

	public void doSomthing()
	{
		System.out.println("功能A");
	}

}
