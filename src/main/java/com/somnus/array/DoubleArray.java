package com.somnus.array;
public class DoubleArray
{
	/*
	 * 							               {{11 , 6 ,   1}				           (0,0) -->(0,2)		(1,0) --> (0,1)	 (2,0)-->(0,0)
	 * {{1,  2,  3, 4,  5}				    {12 , 7 ,   2}				           (0,1) -->(1,2)		(1,1) --> (1,1)  (2,1)-->(1,0)
	 * 													                                   (0,2) -->(2,2)		(1,2) --> (2,1)  (2,2)-->(2,0)
	 * {6,  7 , 8,  9, 10}------------> {13 , 8 ,   3}-------------->       (0,3) -->(3,2)     (1,3) --> (3,1)  (2,3)-->(3,0)
	 * 													                                   (0,4) -->(4,2)		(1,4) --> (4,1)  (2,4)-->(4,0)
	 * {11,12,13,14,15}}			        {14 , 9 ,   4}
	 * 
	 * 							                {15 , 10 , 5}}
	 */
	public static int[][]  createArray()
	{
		int[][] array = new int[3][5];
		
		for(int i=0;i<3;i++)
		{
			int k = 1;
			for(int j=0;j<5;j++)
			{
				array[i][j]= (int)Math.round(Math.random()*10);
				if(k==array[i].length)
				{
					System.out.print(array[i][j]);
					System.out.println("");
				}else{
					System.out.print(array[i][j]+",");
				}
				k++;
			}
		}
		System.out.println("****************************************");
		return array;
	}
	
	public static int[][] replace(int[][] array)
	{
		int lengthX = array.length;
		
		int[] array_= array[0];
		
		int lengthY = array_.length;
		
		int[][] temp = new int[lengthY][lengthX];
		
		for(int i=0;i<lengthY;i++)
		{
			int k = 1;
			for(int j=0;j<lengthX;j++)
			{
				temp[i][j] = array[lengthX-j-1][i];
				
				if(k==temp[i].length)
				{
					System.out.print(temp[i][j]);
					System.out.println("");
				}else{
					System.out.print(temp[i][j]+",");
				}
				k++;
			}
		}
		return temp;
	}
	
	public static void main(String[] args) 
	{
		replace(createArray());
	}
	


}