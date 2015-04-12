package com.somnus.designPatterns.mediator;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mediator m = new President();
		
		Market market = new Market(m);
		Development devp = new Development(m);
		Finacial f = new Finacial(m);
		
		market.selfAction();
		market.outAction();
	}

}
