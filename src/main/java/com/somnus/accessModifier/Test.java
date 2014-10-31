package com.somnus.accessModifier;

public class Test
{
	private static int num = 10;
	public static int add(int num)
	{
		num = num + 10;
		return num;
	}
	public static void change(Person per)
	{
		per.age = 50;
		per = new Person();
		per.age = 100;
	}
	public static void main(String[] args)
	{
		System.out.println("num="+num);
		add(num);
		System.out.println("num="+num);
		
		Person person = new Person();
		System.out.println("per.age="+person.age);
		change(person);
		System.out.println("per.age="+person.age);

	}

}
class Person
{
	public int age = 20;
}