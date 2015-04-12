package com.somnus.designPatterns.facade;

public interface 税务局 {
	void taxCertificate();
}
class 徐汇区税务局 implements 税务局{

	@Override
	public void taxCertificate() {
		System.out.println("办理税务登记");
	}
	
}