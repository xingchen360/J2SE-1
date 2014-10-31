package com.somnus.designPatterns.factoryMethod.factory;

import com.somnus.designPatterns.factoryMethod.Printer;
import com.somnus.designPatterns.factoryMethod.PrinterFactory;
import com.somnus.designPatterns.factoryMethod.product.BetterPrinter;

/*
 * 高速打印机工厂，只返回高速打印机产品
 */
public class BetterPrinterFactory implements PrinterFactory
{

	public Printer getPrinter()
	{
		return new BetterPrinter();
	}
}
