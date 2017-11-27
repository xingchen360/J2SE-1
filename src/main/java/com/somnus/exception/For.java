package com.somnus.exception;

import org.junit.Test;

public class For {
	
	@Test
	public void test(){
		for(int i=0;i<10;i++){
		    try{
		    	System.out.println(i/0);
		    }catch (Exception e){
		    	e.printStackTrace();
		    }
		}
	}
	
	@Test
	public void test2(){
		try{
		    for(int i=0;i<10;i++){
		    	System.out.println(i/0);
		    }
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
