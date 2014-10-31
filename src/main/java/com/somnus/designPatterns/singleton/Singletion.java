package com.somnus.designPatterns.singleton;

public class Singletion
{
	private static Singletion singletion ;
	
	private Singletion()
	{
		
	}
	
	public static Singletion getInstance()
	{
		if(singletion == null)
		{
			singletion = new Singletion();
		}
		return singletion;
	}
}
