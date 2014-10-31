package com.somnus.designPatterns.facade;

public class Facade
{
	//定义被Facade封装的三个部门
	public Payment pay;
	public Cook cook;
	public Waiter waiter;
	
	public Facade()
	{
		pay = new PaymentImpl();
		cook = new CookImpl();
		waiter = new WaiterImpl();
	}
	
	public void serveFood()
	{
		//依次调用三个部门的方法,封装成一个serveFood()方法
		String food = pay.pay();
		food = cook.cook(food);
		waiter.serve(food);
	}
	
}
