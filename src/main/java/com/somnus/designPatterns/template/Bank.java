package com.somnus.designPatterns.template;

public abstract class Bank {
	public void takeNumber(){
		System.out.println("取号排队");
	}
	/* 办理具体的业务*/
	public abstract void transact();
	
	public void evaluate(){
		System.out.println("反馈评分");
	}
	
	public final void process(){
		this.takeNumber();
		this.transact();
		this.evaluate();
	}
}
