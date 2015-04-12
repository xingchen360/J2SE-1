package com.somnus.designPatterns.strategy;

public class StrategyClient {

	public static void main(String[] args) {
		// 客户端没有选择打折策略类
		DiscountContext dc = new DiscountContext(null);

		double price = 79;
		// 使用默认的打折策略
		System.out.println("79元书的默认打折后的价格是:" + dc.getDiscountPrice(price));

		// 客户端选择合适的VIP打折策略
		dc.changeDiscount(new VipDicount());

		double price2 = 89;
		System.out.println("89元的书对VIP用户的价格是" + dc.getDiscountPrice(price2));

	}

}
