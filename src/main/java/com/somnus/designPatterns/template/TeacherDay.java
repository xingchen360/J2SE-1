package com.somnus.designPatterns.template;

public class TeacherDay extends PersonDay {
	// 老师起床
	public void doGetUp() {
		System.out.println("老师起床了，安顿好家人，准备到学校工作");
	}

	// 吃早餐
	public void doEatBreakfast() {
		System.out.println("老师早餐：小米粥、油条");
	}

	// 教学
	public void doSome() {
		System.out.println("老师上课教学");
	}

	// 睡觉
	public void doSleep() {
		System.out.println("老师备完功课睡觉");
	}
}
