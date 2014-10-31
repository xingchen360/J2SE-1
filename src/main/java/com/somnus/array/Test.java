package com.somnus.array;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		 int[] num = { 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,20 };
		 int[] result = new  int[8];
		 for(int i=0;i<result.length;i++){
			 for(int j=0;j<result.length;j++){
				 int radom =num[new Random().nextInt(20)];
				 if(result[j]!=radom){
					 result[i] = radom;
				 }
			 }
		 }
		 for(int s:result){
			 System.out.println(s);
		 }
	}
}
