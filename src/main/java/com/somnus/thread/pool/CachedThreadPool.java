package com.somnus.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {

	public static void main(String[] args) {
		/*线程池的大小会根据执行的任务数动态分配 */
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 1; i <=10; i++){
            final int taskID = i;
            threadPool.execute(new Runnable(){
                public void run(){
                    for (int j = 1; j <= 10; j++){
                        try{
                            Thread.sleep(20);// 为了测试出效果，让每次任务执行都需要一定时间
                        }
                        catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + " is looping of " + j + " for task of " + taskID);
                    }
                }
            });
        }
        threadPool.shutdown();// 任务执行完毕，关闭线程池
	}

}
