package com.somnus.thread;

/** 
 * 这里启动了10W个线程，每个线程睡眠1秒，但用不了10W秒，可能就几秒钟就执行完
 * 
 * @author Somnus
 * date 2015年5月8日 下午3:50:48  
 */
public class ThreadSleep {
    public static void main(String[] args) {
        // 同时启动1000个线程
        for (int i = 0; i < 100000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("********"+Thread.currentThread().getName() +"********");
                }
            }).start();
        }
    }
}
