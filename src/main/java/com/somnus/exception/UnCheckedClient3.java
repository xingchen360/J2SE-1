package com.somnus.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @Title: UnCheckedClient3.java 
 * @Package com.somnus.exception 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月2日 上午11:23:14 
 * @version V1.0 
 */
public class UnCheckedClient3 {
    
    /**
     * 通过数组下标获得指定位置数字
     * ArrayIndexOutOfBoundsException也是一个unchecked异常，
     * 这里开发者并没有显示的new出一个RuntimeException来，但是传参不当还是会发生unchecked异常的
     * 虽然可能会出现异常，但还是不需要声明抛出，也不要在方法中try catch捕获它，更不需要在调用者的方法中去捕获它
     * 原因同UnCheckedClient2中的说明一样
     * @param index
     * @return
     */
    public int getNumFromArray(int index){
        int[] array = new int[]{1,2,3,4};
        int result = array[index];
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        UnCheckedClient3 client = new UnCheckedClient3();
        /** 会抛出异常 ArrayIndexOutOfBoundsException*/
        System.out.println(client.getNumFromArray(5));
        System.out.println("********************");
    }

}
