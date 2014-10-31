package com.somnus.accessModifier;

public class StaticTest {
	public static void main(String[] args)
	{
		Animal a = new Dog();
	}
}
class Animal
{
	static{
		System.out.println("Animal static");
	}
	public Animal()
	{
		System.out.println("动物");
	}
}
class Dog extends Animal
{
	static{
		System.out.println("Dog static");
	}
	public Dog()
	{
		System.out.println("狗狗");
	}
}
