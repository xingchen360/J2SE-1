package com.somnus.thread;
/**
 * 
 * @Title: Thread3Test.java 
 * @Package com.somnus.thread 
 * @Description: 多线程中，局部变量和成员变量的区别
 * 				① 当i为成员变量的时候，那么多个线程对同一个对象的成员变量进行操作时，他们对该成员变量是彼此影响的
 * 					（也就是说一个线程对成员变量的改变会影响到另一个线程）
 * 				②当i为局部变量的时候，那么每个线程都会有一个该局部变量的拷贝，一个线程对该局部变量的改变不会影响到其它线程
 * @author Somnus
 * @date 2015年4月26日 下午9:18:39 
 * @version V1.0
 */
public class Thread3Test{

	public static void main(String[] args){
	    Runner runner = new Runner();
		Thread thread1 = new Thread(runner);
		Thread thread2 = new Thread(runner);
		Thread thread3 = new Thread(runner);
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
class Runner implements Runnable{
	int i ;
	public void run(){
	    /*int i = 0;*/
		while(true){
			System.out.println(Thread.currentThread().getName() + "|number: "+i++);
			try{
				Thread.sleep(500);
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}
			if(50 == i){
				break;
			}
		}
	}
}
