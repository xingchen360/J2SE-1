package com.somnus.thread;

public class Main
{

	/** 
	 * @Title: main 
	 * @Description: TODO
	 * @param @param args  
	 * @return void    
	 * @throws 
	 */
	public static void main(String[] args) {
        ReturnThreadInfo returnThreadInfo = new ReturnThreadInfo();
        returnThreadInfo.start();
        System.out.println(returnThreadInfo.getThreadInfo());
    }

}
class ReturnThreadInfo extends Thread {
    private String str; 

    public ReturnThreadInfo() {
        this.str = "Hello";
    }
    
    public void run(){
        try{
            this.str = "Hello World!";
        }catch(Exception ex){
            
        }
    }
    
    /*返回线程信息：str变量的值*/
    public String getThreadInfo(){
        return this.str;
    }
}

