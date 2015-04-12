package com.somnus.designPatterns.facade;

public interface 银行 {
	void openAccount();
}
class 招商银行 implements 银行{

	@Override
	public void openAccount() {
		System.out.println("银行开户");
	}
	
}