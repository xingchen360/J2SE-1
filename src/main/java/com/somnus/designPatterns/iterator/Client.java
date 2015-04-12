package com.somnus.designPatterns.iterator;

public class Client {

	public static void main(String[] args) {
		ConcreteMyAggregate cma = new ConcreteMyAggregate();
		cma.addObject("a");
		cma.addObject("b");
		cma.addObject("c");
		cma.addObject("d");
		
		Iterator it = cma.createIterator();
		while(it.hasNext()){
			System.out.println(it.getCurrentObj());
			it.next();
		}

	}

}
