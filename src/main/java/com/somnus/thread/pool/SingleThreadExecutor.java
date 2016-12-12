package com.somnus.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {
	
	public static void main(String[] args) {
		/*创建单个线程的线程池，如果当前线程在执行任务时突然中断，则会创建一个新的线程替代它继续执行任务*/
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
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
