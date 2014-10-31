package com.somnus.thread;

public class Thread2Test
{
	public static void main(String[] args)
	{
		new Thread(new Runnable(){
			public void run()
			{
				for(int i = 0; i<100;i++)
				{
					System.out.println("++++++++++++"+i+"++++++++++++");
				}
			}
		}).start();
		
		new Thread(new Runnable(){
			public void run()
			{
				for(int i = 0; i<100;i++)
				{
					System.out.println("**************"+i+"**************");
				}
			}
		}).start();
		
	}
}
