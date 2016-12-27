package com.somnus.async2;

/**
 * @Description: 蛋糕师傅
 * @author Somnus
 * @date 2016年3月9日 下午7:22:52
 * @version 1.0
 */
public class CakeBaker{
	private Cake cake;

	public CakeBaker(int count, char c) {
		System.out.println("making cake(" + count + ", " + c + ") BEGIN");
		this.cake = new Cake(count,c);
		System.out.println("making cake(" + count + ", " + c + ") END");
	}

	public Cake getCake() {
		return cake;
	}

}
