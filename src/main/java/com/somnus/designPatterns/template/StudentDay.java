package com.somnus.designPatterns.template;

public class StudentDay extends PersonDay {
	// 学生起床
	public void doGetUp() {
		System.out.println("学生起床了，准备上学了");
	}

	// 吃早餐
	public void doEatBreakfast() {
		System.out.println("学生吃早餐：牛奶、面包");
	}

	// 上学
	public void doSome() {
		System.out.println("学生上课学习");
	}

	// 睡觉
	public void doSleep() {
		System.out.println("学生做完功课睡觉");
	}
}