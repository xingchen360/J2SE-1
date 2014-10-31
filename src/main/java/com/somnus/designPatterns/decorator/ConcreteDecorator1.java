package com.somnus.designPatterns.decorator;

/*
 * 具体装饰角色
 */
public class ConcreteDecorator1 extends Decorator
{
	public ConcreteDecorator1(Component component)
	{
		super(component);
	}
	
	public void doSomthing()
	{
		super.doSomthing();
		this.doAnotherthing();
	}
	
	private void doAnotherthing()
	{
		System.out.println("功能B");
	}

}
