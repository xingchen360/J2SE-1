package com.somnus.designPatterns.strategy;

public class DiscountContext
{
	//组合一个DiscountStratery对象
	private DiscountStratery strategy;

	public DiscountContext(DiscountStratery strategy)
	{
		this.strategy = strategy;
	}
	//根据实际所使用的DiscountStratery对象得到折扣价
	public double getDiscountPrice(double price)
	{
		//如果strategy为 null 系统自动选择OldDicount类
		if(strategy == null)
		{
			strategy = new OldDicount();
		}
		return this.strategy.getDiscount(price);
	}
	
	//提供切换算法的方法
	public void changeDiscount(DiscountStratery strategy)
	{
		this.strategy = strategy;
	}

}
