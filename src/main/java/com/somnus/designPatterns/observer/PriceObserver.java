package com.somnus.designPatterns.observer;


public class PriceObserver implements Observer
{

	//实现观察者必须实现的update方法
	public void update(Observable o, Object arg)
	{
		if(arg instanceof Double)
		{
			System.out.println("名称观察者: "+o+"物品价格已经改变为: "+ arg);
		}
	}

}
