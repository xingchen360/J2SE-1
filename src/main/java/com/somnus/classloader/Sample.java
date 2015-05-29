package com.somnus.classloader;

public class Sample{
	public int v = 1;
	public Sample(){
		System.out.println("Sample is loaded by:"+this.getClass().getClassLoader());
		new Dog();
	}
}