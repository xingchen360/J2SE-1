package com.somnus;

public class QueryNumber
{
	/*
	 * 5*4*3*2*1
	 */
	public int multiplication(int num)
	{
		if (1 == num)
		{
			return 1;
		}
		else
		{
			return num * multiplication(num - 1);
		}
	}
	/*
	 * 1+2+3+4+5+6+7+8+9+10
	 */
	public int sum(int num)
	{
		if (1 == num)
		{
			return 1;
		}
		else
		{
			return num + sum(num - 1);
		}
	}
	/*
	 * 1,1,2,3,5,8,13,21....
	 */
	public int compute(int n)
	{
		if (1 == n || 2 == n)
		{
			return 1;
		}
		else
		{
			return compute(n - 1) + compute(n - 2);
		}
	}

	public static void main(String[] args)
	{
		QueryNumber query = new QueryNumber();
		System.out.println(query.sum(100));
		System.out.println(query.multiplication(5));
		System.out.println(query.compute(9));
	}
}
