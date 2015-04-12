package com.somnus.designPatterns.strategy;

public class OldDicount implements DiscountStratery {

	public double getDiscount(double originPrice) {
		// 重写getDiscount()方法,提供VIP打折算法
		System.out.println("使用旧书折扣.....");
		return originPrice * 0.7;
	}
}
