package com.somnus;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

public class BigDecimalTest {

	@Test
	public void add() {
		BigDecimal a = new BigDecimal("2.23");
		BigDecimal b = new BigDecimal("1.93");
		System.out.println(a.add(b));
	}

	@Test
	public void subtract() {
		BigDecimal a = new BigDecimal("2.23");
		BigDecimal b = new BigDecimal("1.93");
		System.out.println(a.subtract(b));
	}

	@Test
	public void multiply() {
		BigDecimal a = new BigDecimal("2.23");
		BigDecimal b = new BigDecimal("1.93");
		System.out.println(a.multiply(b));
		System.out.println(a.multiply(b));
	}

	@Test
	public void divide() {
		BigDecimal a = new BigDecimal("1.00");
		BigDecimal b = new BigDecimal("3.00");
		System.out.println(a.divide(b, 3, RoundingMode.UP));// 直接进位处理
		System.out.println(a.divide(b, 3, RoundingMode.DOWN));// 直接删除多余的小数位
		System.out.println(a.divide(b, 3, RoundingMode.HALF_UP));// 四舍五入 如果是5则向上舍
		System.out.println(a.divide(b, 3, RoundingMode.HALF_DOWN));// 四舍五入 如果是5则向下舍
	}

}
