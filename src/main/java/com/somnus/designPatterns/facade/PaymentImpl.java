package com.somnus.designPatterns.facade;

public class PaymentImpl implements Payment
{

	// 模拟顾客支付费用的方法
	public String pay()
	{
		String food = "快餐";
		
		System.out.println("您已经向收银员支付了费用,您购买的食物是: "+food);
		
		return food;
	}

}
