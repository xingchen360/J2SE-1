package com.somnus;

import java.util.ArrayList;


public class ExampleClient {

	public static void main(String[] args) {
		Example exampel = new Example();
		exampel.or().andBankCodeBetween("1", "9").
		andBankCodeEqualTo("a").andBankCodeIn(new ArrayList<String>());
	}
}
