package com.somnus.thread.concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @description: 
 * @author: Somnus
 * @version: 1.0
 * @createDate: 2017年12月28日 下午8:56:43
 * Modification  History:
 *    Date        Author        Version        Description
 * -----------------------------------------------------------------------------------
 * 2017年12月28日             Somnus         1.0           控制并发线程数
 假如现在有20个人去售票厅买票，但是窗口只有2个，那么同时能够买票的只能有2个人，
   当2个人中任意一个人买好票离开之后，等待的18个人中又会有一个人可以占用窗口买票。
 */
public class SemaphoreTest {
	
	public static void main(String[] args) {
		/** 定义窗口个数 **/
		Semaphore semaphore = new Semaphore(3);
		
		ExecutorService executor = Executors.newCachedThreadPool();
		/** 模拟20个用户 **/
		for (int i = 1; i <= 20; i++) {
			final int offset = i;
			executor.execute(new Runnable() {
				@Override
				public void run() {
					try {
						/** 获取信号量许可 **/
						semaphore.acquire();
						System.out.println("用户【" + offset+ "】进入窗口，准备买票");
						TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
						System.out.println("用户【" + offset+ "】买票完成，即将离开");
						TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
						System.out.println("用户【" + offset+ "】离开售票窗口");
						System.out.println(Thread.currentThread().getName() + " for offset of " + offset);
						semaphore.release();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			});
		}
		executor.shutdown();
	}
}
