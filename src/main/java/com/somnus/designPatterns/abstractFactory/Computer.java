package com.somnus.designPatterns.abstractFactory;


public class Computer{
	private Printer out;

	public Computer(Printer out){
		this.out = out;
	}
	public void keyIn(String msg){
		out.getData(msg);
	}
	public void print(){
		out.out();
	}
	public static void main(String[] args){
		PrinterFactoryFactory pff = new PrinterFactoryFactory();
		PrinterFactory of = pff.getPrintFactory("common");
		Computer c = new Computer(of.getPrinter("hp"));
		c.keyIn("hello");
		c.keyIn("world");
		c.print();
		
		PrinterFactoryFactory pff2 = new PrinterFactoryFactory();
		PrinterFactory of2 = pff2.getPrintFactory("hp");
		Computer c2 = new Computer(of2.getPrinter("common"));
		c2.keyIn("hello");
		c2.keyIn("world");
		c2.print();
	}
}
