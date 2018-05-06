package com.somnus.async2;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Description: TODO
 * @author Somnus
 * @date 2016年3月9日 下午7:21:32
 * @version 1.0
 */
public class CakeShop {

	public FutureTask<Cake> request(final int count, final char c) {

		System.out.println("request(" + count + ", " + c + ") BEGIN");
		
		Callable<Cake> callable = new Callable<Cake>() {
			@Override
			public Cake call() {
				CakeBaker cakeBaker = new CakeBaker(count, c);
				return cakeBaker.getCake();
			}
		};
		
		FutureTask<Cake> future = new FutureTask<Cake>(callable);
		
		System.out.println("request(" + count + ", " + c + ") END");
		
		return future;

	}
}
