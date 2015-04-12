package com.somnus.designPatterns.facade;

public interface 质检局 {
	void orgCodeCertificate();//办理组织机构代码
}
class 徐汇区质检局 implements 质检局{

	@Override
	public void orgCodeCertificate() {
		System.out.println("办理组织机构代码证");
	}
	
}