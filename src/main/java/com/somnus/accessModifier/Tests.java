package com.somnus.accessModifier;

public class Tests {
	char[] ch = {'h','e','l','l','o'};
	int num = 9;
	String str = "love";
	void change(int num,char[] ch,String str){
		num = 10;
		ch[2] = 'm';
		ch = new char[]{'w','o','r','l','d'};
		ch[2] = 'n';
		str = "you";
	}
	public static void main(String[] args) {
		Tests t = new Tests();
		t.change(t.num,t.ch,t.str);
		System.out.print("num:"+t.num+" str:"+t.str+" ch:");
		System.out.println(t.ch);
	}

}
