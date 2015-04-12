package com.somnus.designPatterns.facade;

public class RegisterFacade {
	public void register(){
		工商局 a = new 徐汇区工商局();
		a.checkName();
		质检局 b = new 徐汇区质检局();
		b.orgCodeCertificate();
		税务局 c = new 徐汇区税务局();
		c.taxCertificate();
		银行 d = new 招商银行();
		d.openAccount();
	}
}
