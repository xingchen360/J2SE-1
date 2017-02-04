package com.somnus.math;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.junit.Test;

public class NumeralUtil {
    
	/*
	 * 0.47以百分数输出
	 */
	@Test
	public void test1(){
		NumberFormat nf = NumberFormat.getPercentInstance();
		System.out.println(nf.format(0.47));
	}
	
	//#表示没有则为空，0表示如果没有则该位补0
	@Test
	public void test2(){
		double pi = Math.PI;
		System.out.println(pi);
		System.out.println("取一位整数:"+new DecimalFormat("0").format(pi));
		System.out.println("取一位整数和两位小数:"+new DecimalFormat("0.00").format(pi));
		System.out.println("取两位整数和三位小数，整数不足部分以0填补:"+new DecimalFormat("00.000").format(pi));
		
	}
	
	@Test
	public void test3(){
		double pi = Math.PI;
		System.out.println(pi);
		System.out.println("取所有整数部分:"+new DecimalFormat("#").format(pi));
		System.out.println("取一位整数和两位小数:"+new DecimalFormat("#.##").format(pi));
		System.out.println(new DecimalFormat("##.###").format(pi));
		
	}

}
