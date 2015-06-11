package com.somnus.accessModifier;

/**
 * 执行顺序
 * @Title: StaticTest.java 
 * @Package com.somnus.accessModifier 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月11日 下午12:47:12 
 * @version V1.0
 */
public class StaticTest {
	public static void main(String[] args){
		Animal a = new Dog();
	}
}
class Animal{
	static{
		System.out.println("Animal static");
	}
	public Animal(){
		System.out.println("Animal constructor");
	}
}
class Dog extends Animal{
	static{
		System.out.println("Dog static");
	}
	public Dog(){
		System.out.println("Dog constructor");
	}
}
