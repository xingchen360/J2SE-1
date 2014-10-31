package com.somnus.designPatterns.abstractFactory.factory;

import com.somnus.designPatterns.abstractFactory.Printer;
import com.somnus.designPatterns.abstractFactory.PrinterFactory;
import com.somnus.designPatterns.abstractFactory.product.DellBetterPrinter;
import com.somnus.designPatterns.abstractFactory.product.HpBetterPrinter;
/*
 * a、生产高速打印机的工厂
 * b、可以是戴尔，也可以是惠普
 */
public class BetterPrinterFactory implements PrinterFactory
{

	public Printer getPrinter(String type)
	{
		if(type.equals("dell"))
		{
			return new DellBetterPrinter();
		}
		else if(type.equals("hp"))
		{
			return new HpBetterPrinter();
		}
		else
		{
			return null;
		}
	}

}
