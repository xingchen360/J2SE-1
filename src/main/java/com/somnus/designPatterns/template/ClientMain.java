package com.somnus.designPatterns.template;

public class ClientMain {
	public static void main(String[] args) {
		PersonDay p1 = new TeacherDay();
		p1.day();
		System.out.println("-------------------------------");
		PersonDay p2 = new StudentDay();
		p2.day();
	}
}
