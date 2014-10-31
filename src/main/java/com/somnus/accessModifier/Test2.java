package com.somnus.accessModifier;

public class Test2 {
	String str = new String("good");   
	char[] ch = { 'a', 'b', 'c',97 };   
	int in = 5;
	public void change(int in,String str, char[] ch) 
	{   
		in = 10;
        str = "test ok";   
        ch[0] = 'g';   
    }   
	public static void main(String args[])
	{   
		Test2 ex = new Test2();   
        ex.change(ex.in,ex.str, ex.ch);   
        System.out.print(ex.in+" and "+ex.str + " and ");   
        System.out.println(ex.ch);   
    }   
	
	public void change(char[] ch) 
	{   
		ch = new char[]{ 'A', 'B', 'C' };   
    }   
}
