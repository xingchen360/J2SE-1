package com.somnus.thread;

public class ThreadTest11
{
	public static void main(String[] args)
	{
		final Outputter output = new Outputter();

		new Thread()
		{
			public void run()
			{
				output.output("zhangsan");
			};
		}.start();

		new Thread()
		{
			public void run()
			{
				output.output("lisi");
			};
		}.start();
	}
}

class Outputter
{
	public void output(String name)
	{
		// TODO 为了保证对name的输出不是一个原子操作，这里逐个输出name的每个字符
		for (int i = 0; i < name.length(); i++)
		{
			System.out.print(name.charAt(i));
		}
	}

	public void output2(String name)
	{
		synchronized (this)
		{
			for (int i = 0; i < name.length(); i++)
			{
				System.out.print(name.charAt(i));
			}
		}
	}
	
	public synchronized void output3(String name)
	{
		// TODO 为了保证对name的输出不是一个原子操作，这里逐个输出name的每个字符
		for (int i = 0; i < name.length(); i++)
		{
			System.out.print(name.charAt(i));
		}
	}
}