package com.somnus;

public class Common
{

	/** 
	 * @Title: main 
	 * @Description: TODO
	 * @param @param args  
	 * @return void    
	 * @throws 
	 */
	public static void main(String[] args)
	{
		Common com = new Common();
		
		System.out.println(com.commY(40, 100));
	}
	
	public int commY(int a,int b)
	{
		int i = 1;
		int commY = 0;
		int c = a;
		if(c<b) c = b;
		while(i<=c)
		{
			if(a%i==0 && b%i==0)
			{
				commY = i;
			}
			i++;
		}
		return commY;
	}

}
