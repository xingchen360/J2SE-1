package com.somnus.designPatterns.simpleFactory;

import com.somnus.designPatterns.simpleFactory.product.BetterPrinter;
import com.somnus.designPatterns.simpleFactory.product.CommonPrinter;

public class PrinterFactory{
	public Printer getPrinter(String type){
		if("common".equals(type)){
			return new CommonPrinter();
		}
		else if("better".equals(type)){
			return new BetterPrinter();
		}
		else {
			return null;
		}
	}
}
