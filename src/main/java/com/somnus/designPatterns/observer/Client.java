package com.somnus.designPatterns.observer;

public class Client
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// 创建一个被观察者对象
		Product p = new Product();
		
		//创建两个观察者对象
		Observer no = new NameObserver();
		Observer po = new PriceObserver();
		
		//向被观察者对象上注册上两个观察者对象
		p.registerObserver(no);
		p.registerObserver(po);
		
		//程序调用setter方法来改变Product的name和price属性
		p.setName("笔记本");
		p.setPrice(321);

	}

}
