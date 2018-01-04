package com.somnus.thread.pool;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description: 
 * @author: Somnus
 * @version: 1.0
 * @createDate: 2017年4月4日 下午11:20:36
 * Modification  History:
 *    Date        Author        Version        Description
 * -----------------------------------------------------------------------------------
 * 2017年4月4日             Somnus         1.0             初始化
 */
public class CachedThreadPool {
	
	public static void main(String[] args) {
		/*返回一个可根据实际情况调整线程个数的线程池，不限制最大线程数量，若用空闲的线程则执行任务，
		 * 若无任务则不创建线程。并且每一个空闲线程会在60s后自动回收*/
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 1; i <=10; i++){
            final int taskID = i;
            executor.execute(() -> {
            	for (int j = 1; j <= 10; j++){
                    try{
                    	TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));// 为了测试出效果，让每次任务执行都需要一定时间
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " is looping of " + j + " for task of " + taskID);
                }
            });
        }
        /** 
         * shutdown 允许之前已经提交但未执行或未完成的任务继续完成它，平滑的关闭ExecutorService，
         * 当此方法被调用时，ExecutorService停止接收新的任务并且等待已经提交的任务（包含提交正在执行和提交未执行）执行完成。
         * 当所有提交任务执行完毕，线程池即被关闭。
         * 
         * shutdownNow 阻止已经提交(但尚未运行的)的任务运行并且尝试停止正在运行的任务
         */
        executor.shutdown();// 任务执行完毕，关闭线程池
	}

}