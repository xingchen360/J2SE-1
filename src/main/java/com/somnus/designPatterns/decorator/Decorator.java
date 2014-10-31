package com.somnus.designPatterns.decorator;

/*
 * 装饰角色
 */
public class Decorator implements Component
{
	private Component component;
	
	public Decorator(Component component)
	{
		this.component = component;
	}
	public void doSomthing()
	{
		component.doSomthing();
	}

}
