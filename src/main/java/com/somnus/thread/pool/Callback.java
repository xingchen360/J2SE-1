package com.somnus.thread.pool;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class Callback {
	
	@Test
	public void  futureTask() throws Exception {
		/* 创建单个线程的线程池，如果当前线程在执行任务时突然中断，则会创建一个新的线程替代它继续执行任务 */
		ExecutorService executor = Executors.newSingleThreadExecutor();

		FutureTask<Integer> future = new FutureTask<Integer>(() -> {
			int sum = 0;
			for (int j = 1; j <= 10; j++) {
				try {
					TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));// 为了测试出效果，让每次任务执行都需要一定时间
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " is looping of " + j);
				sum += j;
			}
			return sum;
		});

		executor.execute(future);
		
		System.out.println("你走你的，我先走一步");
		Thread.sleep(10000);//模拟业务逻辑也在做自己的事情，同时开工
		
		int result = future.get(5000, TimeUnit.MILLISECONDS); //取得结果，同时设置超时执行时间为5s
		
		System.out.println(result);
		
		executor.shutdown();// 任务执行完毕，关闭线程池
	}
	
	@Test
	public void future() throws Exception {
		/* 创建单个线程的线程池，如果当前线程在执行任务时突然中断，则会创建一个新的线程替代它继续执行任务 */
		ExecutorService executor = Executors.newSingleThreadExecutor();

		Future<Integer> future = executor.submit(() -> {
			int sum = 0;
			for (int j = 1; j <= 10; j++) {
				try {
					TimeUnit.MILLISECONDS.sleep(new Random().nextInt(10));// 为了测试出效果，让每次任务执行都需要一定时间
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " is looping of " + j);
				sum += j;
			}
			return sum;
		});

		System.out.println("你走你的，我先走一步");
		Thread.sleep(10000);//模拟业务逻辑也在做自己的事情，同时开工
		
		int result = future.get(5000, TimeUnit.MILLISECONDS); //取得结果，同时设置超时执行时间为5s
		
		System.out.println(result);//
		
		executor.shutdown();// 任务执行完毕，关闭线程池
	}

}
