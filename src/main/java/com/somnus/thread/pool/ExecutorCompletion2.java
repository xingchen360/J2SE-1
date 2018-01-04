package com.somnus.thread.pool;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorCompletion2 {
	
	public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(100);
  
        // 构建完成服务  
        CompletionService<Long> completionService = new ExecutorCompletionService<Long>(executor);
        
        final int groupNum = 1000000/100;
        
        for (int i = 1; i <= 100; i++){
        	final int start = (i -1) * groupNum +1;
			final int end = i * groupNum;
    		completionService.submit(() -> {
    			Long sum = 0L;
				for (int j = start; j <= end; j++) {
					System.out.println(Thread.currentThread().getName() + " is looping of " + j + " for start of " + start + " for end of " + end);
					sum += j;
				}
				return sum;
    		});//返回结果类型FutureTask  
        }
		
		System.out.println("你走你的，我先走一步");
		Thread.sleep(10000);//模拟业务逻辑也在做自己的事情，同时开工
		
		long result = 0L;
  
        for (int i = 0; i < 100; i++) {
            try {  
                result += completionService.take().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
  
        // 所有任务已经完成,关闭线程池  
        System.out.println("执行完毕...." + result);
        executor.shutdown();  
	}

}