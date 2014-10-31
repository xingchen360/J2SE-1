package com.somnus.designPatterns.simpleFactory.product;

import com.somnus.designPatterns.simpleFactory.Printer;
/**
 * 普通打印机
 */
public class CommonPrinter implements Printer
{
	private  final int MAX_CACHE_LINE = 10;
	private String[] printData = new String[MAX_CACHE_LINE];
	
	private int dataNum = 0;

	public void getData(String msg)
	{
		if(dataNum >= MAX_CACHE_LINE)
		{
			System.out.println("输出队列已满,添加失败");
		}
		else
		{
			printData[dataNum++] = msg;
		}
	}

	public void out()
	{
		while(dataNum>0)
		{
			System.out.println("普通打印机打印: "+printData[0]);
			
			System.arraycopy(printData,1,printData,0,--dataNum);
		}
	}
}
