package com.somnus.designPatterns.strategy;

public class VipDicount implements DiscountStratery {

	public double getDiscount(double originPrice) {
		// 重写getDiscount()方法,提供VIP打折算法
		System.out.println("使用VIP折扣.....");
		return originPrice * 0.5;
	}
}
