package com.somnus.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @Title: CheckedClient3.java 
 * @Package com.somnus.exception 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月2日 上午11:23:14 
 * @version V1.0 
 */
public class CheckedClient3 {
    private transient Logger log = LoggerFactory.getLogger(this.getClass());
    
    /**
     * 如果你不想处理就抛出去，交给调用你的方法去处理它
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    public String getClassSimpleName(String name) throws ClassNotFoundException{
        Class<?> demo = Class.forName(name);;
        System.out.println("&&&&&&&&&&&&&&&&&&&&&");
        return demo.getSimpleName();
    }

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args){
        CheckedClient3 client = new CheckedClient3();
        try {
            client.getClassSimpleName("com.somnus.exception.BizExceptio");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("********************");
    }

}
