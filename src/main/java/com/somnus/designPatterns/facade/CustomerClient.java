package com.somnus.designPatterns.facade;

public class CustomerClient
{

	public void haveDinner()
	{
		//直接依赖于Facade实现用餐方法
		Facade f = new Facade();
		
		f.serveFood();
	}
	public static void main(String[] args)
	{
		CustomerClient customer = new CustomerClient();
		customer.haveDinner();
	}

}
