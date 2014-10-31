package com.somnus.designPatterns.abstractFactory.factory;

import com.somnus.designPatterns.abstractFactory.Printer;
import com.somnus.designPatterns.abstractFactory.PrinterFactory;
import com.somnus.designPatterns.abstractFactory.product.DellCommonPrinter;
import com.somnus.designPatterns.abstractFactory.product.HpCommonPrinter;
/*
 * a、生产普通打印机的工厂
 * b、可以是戴尔，也可以是惠普
 */
public class CommonPrinterFactory implements PrinterFactory
{
	public Printer getPrinter(String type)
	{
		if(type.equals("dell"))
		{
			return new DellCommonPrinter();
		}
		else if(type.equals("hp"))
		{
			return new HpCommonPrinter();
		}
		else
		{
			return null;
		}
	}

}
