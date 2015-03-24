package com.somnus.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @description: TODO 
 * @author Somnus
 * date 2015年3月24日 上午11:13:53  
 */
public class ExceptionClient {
    private static final Logger log = LoggerFactory.getLogger(ExceptionClient.class);
    
    /**
     * 自定义 unchecked 异常抛出
     * @param parameter
     * @return
     */
    public String defined(String parameter)throws Exception{
        if(!"A".equals(parameter)){
            throw new BizException("只接收字母A");
        }
        String result = "1:" + parameter;
        return result;
    }
    /**
     * 個人檔案
     * @param age
     * @return
     */
    public String profile(int age)throws Exception{
        if(age<0||age>120){
            throw new IllegalArgumentException("age must be (0<age<120)");
        }
        return "年龄是：" + age + "岁";
    }
    /**
     * 获得类简称
     * @param name
     * @return
     */
    public String getClassSimpleName(String name){
        Class<?> demo = null;
        try {
            demo = Class.forName(name);
        } catch (ClassNotFoundException e) {
            /*e.printStackTrace();*/
            log.error(e.getMessage(), e);
        }
        return demo.getSimpleName();
    }
    
    /**
     * 除法
     * @param num1 被除数
     * @param num2 除数（改数不能为0）
     * @return
     */
    public int division(int num1,int num2){
        int result = num1/num2;
        return result;
    }
    
    /**
     * 通过数组下标获得指定位置数字
     * @param index
     * @return
     */
    public int getNumFromArray(int index){
        int[] array = new int[]{1,2,3,4};
        int result = array[index];
        return result;
    }
    
    public static void main(String[] args) {
        ExceptionClient client = new ExceptionClient();
        
        try {
            System.out.println(client.defined("A"));
        } catch (Exception e) {
            /*e.printStackTrace();*/
            log.error(e.getMessage(), e);
        }
        
        try {
            System.out.println(client.profile(100));
        } catch (Exception e) {
            /*e.printStackTrace();*/
            log.error(e.getMessage(), e);
        }
        
        /** 会抛出异常ClassNotFoundException*/
        System.out.println(client.getClassSimpleName("com.somnus.exception.BizExceptio"));
        
        /** 会抛出异常 ArithmeticException*/
        System.out.println(client.division(10, 2));
        
        /** 会抛出异常 ArrayIndexOutOfBoundsException*/
        System.out.println(client.getNumFromArray(5));
    }
    
}
