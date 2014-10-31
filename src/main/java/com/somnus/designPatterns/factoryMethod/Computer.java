package com.somnus.designPatterns.factoryMethod;

import com.somnus.designPatterns.factoryMethod.factory.CommonPrinterFactory;

public class Computer
{
	private Printer out;

	public Computer(Printer out)
	{
		this.out = out;
	}
	public void keyIn(String msg)
	{
		out.getData(msg);
	}
	public void print()
	{
		out.out();
	}
	public static void main(String[] args)
	{
		PrinterFactory of = new CommonPrinterFactory();
		
		Computer c = new Computer(of.getPrinter());
		
		c.keyIn("hello");
		c.keyIn("world");
		c.print();
	}
}
