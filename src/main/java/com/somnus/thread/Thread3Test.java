package com.somnus.thread;

public class Thread3Test
{

	public static void main(String[] args)
	{
		Thread33 thread33 = new Thread33();
		Thread thread11 = new Thread(thread33);
		Thread thread22 = new Thread(thread33);
		thread11.start();
		thread22.start();
	}
}
class Thread33 implements Runnable
{
	int i ;
	public void run()
	{
//		int i = 0;
		while(true)
		{
			System.out.println("number: "+i++);
			try
			{
				Thread.sleep(2000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			if(50 == i)
			{
				break;
			}
		}
	}
}
