package com.somnus.designPatterns.factoryMethod.factory;

import com.somnus.designPatterns.factoryMethod.Printer;
import com.somnus.designPatterns.factoryMethod.PrinterFactory;
import com.somnus.designPatterns.factoryMethod.product.CommonPrinter;

/*
 * 普通打印机工厂，只返回普通打印机产品
 */
public class CommonPrinterFactory implements PrinterFactory
{

	public Printer getPrinter()
	{
		return new CommonPrinter();
	}
}
