package com.somnus;

public class MaxSameString {
	public String  getResualt(String str1,String str2) 
	{
		String max = "";
		for (int i = 0; i < str2.length(); i++) 
		{
			String temp1 = str2.substring(i);
			for (int y = temp1.length() - 1; y >= 0; y--) 
			{
				String temp2 = temp1.substring(0, y);
				if (str1.indexOf(temp2) != -1 && temp2.length() > max.length())
					max = temp2;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		MaxSameString msss = new MaxSameString();
		System.out.println(msss.getResualt("abcdefg","xxxabxxxxcdexxx"));
	}
}
