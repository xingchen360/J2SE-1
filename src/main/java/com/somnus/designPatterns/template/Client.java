package com.somnus.designPatterns.template;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank bank = new Bank(){
			@Override
			public void transact() {
				// TODO Auto-generated method stub
				System.out.println("我要取钱");
			}
		};
		bank.process();
	}

}
