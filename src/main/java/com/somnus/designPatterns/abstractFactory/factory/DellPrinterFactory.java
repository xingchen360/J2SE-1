package com.somnus.designPatterns.abstractFactory.factory;

import com.somnus.designPatterns.abstractFactory.Printer;
import com.somnus.designPatterns.abstractFactory.PrinterFactory;
import com.somnus.designPatterns.abstractFactory.product.DellBetterPrinter;
import com.somnus.designPatterns.abstractFactory.product.DellCommonPrinter;
/*
 * a、生产戴尔打印机的工厂
 * b、可以是高速打印机，也可以是普通打印机
 */
public class DellPrinterFactory implements PrinterFactory
{
	public Printer getPrinter(String vendor)
	{
		if(vendor.equals("better"))
		{
			return new DellBetterPrinter();
		}
		else if(vendor.equals("common"))
		{
			return new DellCommonPrinter();
		}
		else
		{
			return null;
		}
	}

}
