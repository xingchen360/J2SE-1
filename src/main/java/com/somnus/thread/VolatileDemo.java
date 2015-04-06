package com.somnus.thread;

public class VolatileDemo {
	private volatile int number = 0;
	public int getNumber(){
		return this.number;
	}
	public void increase(){
		this.number++;
	}

	public static void main(String[] args) {
		final VolatileDemo demo = new VolatileDemo();
		for(int i = 0;i<500;i++){
			new Thread(new Runnable(){
				@Override
				public void run() {
					demo.increase();
				}
			}).start();;
		}
		//如果还有子线程在运行，主线程就让出cpu资源
		//直到所有子线程都运行完了，主线程再继续往下执行
		while(Thread.activeCount()>1){
			Thread.yield();
		}
		System.out.println("number:"+demo.getNumber());
	}
}
