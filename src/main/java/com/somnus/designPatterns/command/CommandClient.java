package com.somnus.designPatterns.command;

public class CommandClient
{

	public static void main(String[] args)
	{
		ProcessArray pa = new ProcessArray();
		
		int [] target ={3,-4,6,4};
		//第一次处理数组,具体处理行为取决于Command对象
		pa.each(target, new Command()
		{
			//重写process()方法,决定具体的处理行为
			public void process(int[] target)
			{
				for(int tmp : target)
				{
					System.out.println("迭代输出目标数组的元素:"+tmp);
				}
			}
		});
		System.out.println("-------------------------------");
		//第二次次处理数组,具体处理行为取决于Command对象
		pa.each(target, new Command()
		{
			//重写process()方法,决定具体的处理行为
			public void process(int[] target)
			{
				int sum = 0;
				for(int tmp : target)
				{
					sum += tmp;
				}
				System.out.println("数组元素的总和是:"+sum);
			}
		});

	}

}
