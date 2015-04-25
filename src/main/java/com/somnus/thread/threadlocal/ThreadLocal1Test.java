/**
 * 
 */
package com.somnus.thread.threadlocal;

/**
 * @Title: ThreadLocalTest.java
 * @Package com.somnus.thread.threadlocal
 * @Description: TODO
 * @author Somnus
 * @date 2015年4月25日 上午9:54:27
 * @version V1.0
 */
public class ThreadLocal1Test {
	// 创建一个Integer型的线程本地变量
	public static final ThreadLocal<Integer> local = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return 0;
		}
	};

	public static void main(String[] args) throws InterruptedException {
		for (int j = 0; j < 5; j++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					// 获取当前线程的本地变量，然后累加5次
					int num = local.get();
					for (int i = 0; i < 5; i++) {
						num++;
					}
					// 重新设置累加后的本地变量
					local.set(num);
					System.out.println(Thread.currentThread().getName() + " : " + local.get());
				}
			}, "Thread-" + j).start();
		}
	}
}