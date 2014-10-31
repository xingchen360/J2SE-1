package com.somnus.designPatterns.abstractFactory.factory;

import com.somnus.designPatterns.abstractFactory.Printer;
import com.somnus.designPatterns.abstractFactory.PrinterFactory;
import com.somnus.designPatterns.abstractFactory.product.HpBetterPrinter;
import com.somnus.designPatterns.abstractFactory.product.HpCommonPrinter;
/*
 * a、生产惠普打印机的工厂
 * b、可以是高速打印机，也可以是普通打印机
 */
public class HpPrinterFactory implements PrinterFactory
{
	public Printer getPrinter(String vendor)
	{
		if(vendor.equals("better"))
		{
			return new HpBetterPrinter();
		}
		else if(vendor.equals("common"))
		{
			return new HpCommonPrinter();
		}
		else
		{
			return null;
		}
	}

}
