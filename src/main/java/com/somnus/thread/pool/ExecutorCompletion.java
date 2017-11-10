package com.somnus.thread.pool;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 与ExecutorService一样，CompletionService也可以提交异步任务，它的不同是，它可以按任务完成顺序获取结果
 * @ClassName:     ExecutorCompletion.java
 * @Description:   
 * @author         Somnus
 * @version        V1.0  
 * @Since          JDK 1.7
 * @Date           2017年11月9日 下午3:07:13
 */
public class ExecutorCompletion {
	
	public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
  
        // 构建完成服务  
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executor);
        
        for (int i = 1; i <= 10; i++){
        	final int taskID = i;
        	Callable<Integer> callable = new Callable<Integer>() {
    			public Integer call() {
    				int sum = 0;
    				for (int j = 1; j <= 10; j++) {
    					try {
    						TimeUnit.SECONDS.sleep(new Random().nextInt(10));// 为了测试出效果，让每次任务执行都需要一定时间
    					} catch (InterruptedException e) {
    						e.printStackTrace();
    					}
    					System.out.println(Thread.currentThread().getName() + " is looping of " + j + " for task of " + taskID);
    					sum += j;
    				}
    				return sum+taskID;
    			}
    		};
            
    		completionService.submit(callable);//返回结果类型FutureTask  
        }
		
		System.out.println("你走你的，我先走一步");
		Thread.sleep(10000);//模拟业务逻辑也在做自己的事情，同时开工
  
        // 按照完成顺序,打印结果  
        for (int i = 1; i <= 10; i++) {
            try {  
                System.out.println(completionService.take().get());// 阻塞，知道有任务完成可以获取结果  
                // System.out.println(completionService.poll());//poll直接返回，不阻塞。但是没有完成的任务则返回null
                // System.out.println(completionService.poll(5, TimeUnit.SECONDS));//阻塞等待指定时间，如果有完成结果返回，没有的直接返回null<span style="white-space:pre">                                                                               <span style="white-space:pre">  </span>// completionService.submit(new RunnableTask(),2);//completionService提交Runnable任务是无法获取结果的</span>  
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
  
        // 所有任务已经完成,关闭线程池  
        System.out.println("执行完毕....");
        executor.shutdown();  
	}

}
