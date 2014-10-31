package com.somnus.thread;

public class ThreadTest15
{
	public static void main(String[] args)
	{
		final Math math = new Math();
		for(int i=0;i<2;i++)
		{
			new Thread(new Runnable(){
				public void run()
				{
					for(int i=0;i<10;i++)
					{
						math.increase();
					}
				}
			}).start();
			
			new Thread(new Runnable(){
				public void run()
				{
					for(int i=0;i<10;i++)
					{
						math.decrease();
					}
				}
			}).start();
		}
	}
}

class Math
{
	private int num;

	public synchronized void increase()
	{
		if(num != 0)
		{
			try
			{
				wait();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		num++;
		System.out.println(Thread.currentThread().getName() + "[" + num+"]");
		notify();
	}
	public synchronized void decrease()
	{
		if(num == 0)//如果用if此线程唤醒后，讲继续往下执行
		{
			try
			{
				wait();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		num--;
		System.out.println(Thread.currentThread().getName() + "{" + num+"}");
		notify();
	}
	
}