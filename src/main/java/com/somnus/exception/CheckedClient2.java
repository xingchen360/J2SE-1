package com.somnus.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @Title: Client2.java 
 * @Package com.somnus.exception 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月2日 上午11:23:14 
 * @version V1.0 
 */
public class CheckedClient2 {
    private transient Logger log = LoggerFactory.getLogger(this.getClass());
    
    /**
     * Exception 异常
     * checked异常  需要try catch
     * 如果你的业务逻辑中是有该异常情况，而且你希望后面的代码继续执行，
     * catch后打印下日志，可做处理也可不做处理，交给调用者继续执行
     * @param name
     * @return
     */
    public String getClassSimpleName(String name){
        Class<?> demo = null;
        try {
            demo = Class.forName(name);
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage(), e);
            demo = BizException.class;
        }
        System.out.println("&&&&&&&&&&&&&&&&&&&&&");
        return demo.getSimpleName();
    }

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args){
        CheckedClient2 client = new CheckedClient2();
        client.getClassSimpleName("com.somnus.exception.BizExceptio");
        System.out.println("********************");
    }

}
