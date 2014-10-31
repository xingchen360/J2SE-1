package com.somnus.designPatterns.abstractFactory;

import com.somnus.designPatterns.abstractFactory.factory.BetterPrinterFactory;
import com.somnus.designPatterns.abstractFactory.factory.CommonPrinterFactory;
import com.somnus.designPatterns.abstractFactory.factory.DellPrinterFactory;
import com.somnus.designPatterns.abstractFactory.factory.HpPrinterFactory;

/*
 * 制造出一个想要的工厂，去生产相对应的打印机
 */
public class PrinterFactoryFactory
{
	public  PrinterFactory getPrintFactory(String type)
	{
		if(type.equals("common"))//造出一个生产普通打印机的工厂
		{
			return new CommonPrinterFactory();
		}
		else if(type.equals("better"))//造出一个生产高速打印机的工厂
		{
			return new BetterPrinterFactory();
		}
		else if(type.equals("dell"))//造出一个生产戴尔打印机的工厂
		{
			return new DellPrinterFactory();//造出一个生产惠普打印机的工厂
		}
		else if(type.equals("hp"))
		{
			return new HpPrinterFactory();
		}
		else
		{
			return null;
		}
	}
}
