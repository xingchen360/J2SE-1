package com.somnus.thread.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description: 
 * @author: Somnus
 * @version: 1.0
 * @createDate: 2017年12月30日 下午3:47:38
 * Modification  History:
 *    Date        Author        Version        Description
 * -----------------------------------------------------------------------------------
 * 2017年12月30日             Somnus         1.0             初始化
 * 
 */
public class CountDownLatchTest {

	public static void main(String[] args) throws InterruptedException {
		
		final CountDownLatch latch = new CountDownLatch(10);
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for (int i = 1; i <= 10; i++) {
			final int offset = i;
			executor.execute(new Runnable() {
				@Override
				public void run() {
					try {
						System.out.println("任务【" + offset+ "】正在执行任务" + Thread.currentThread().getName() + " for offset of " + offset);
						TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
						System.out.println("任务【" + offset+ "】执行完毕" + Thread.currentThread().getName() + " for offset of " + offset);
						latch.countDown();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			});
		}
		
		System.out.println("等待其它子任务执行完毕，主线程才开始执行任务");
		latch.await();
		System.out.println("主线程开始执行任务。。。。");
		executor.shutdown();
	}

}
