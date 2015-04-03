package com.somnus.thread;

public class ThreadTest10{
	public static void main(String[] args)
	{
		final Count count = new Count();
		for (int i = 0; i < 10; i++)
		{
			new Thread(new Runnable(){
				public void run()
				{
					count.count();
				}
			}).start();
		}
	}
}

class Count{
	private int num;

	public void count()
	{
		for (int i = 1; i <= 10; i++)
		{
			num += i;
		}
		System.out.println(Thread.currentThread().getName() + "-" + num);
	}
}