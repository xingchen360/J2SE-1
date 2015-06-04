package com.somnus.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @Title: CheckedClient4.java 
 * @Package com.somnus.exception 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月2日 上午11:23:14 
 * @version V1.0 
 */
public class CheckedClient4 {
    private transient Logger log = LoggerFactory.getLogger(this.getClass());
    
    public String getClassSimpleName(String name) {
        Class<?> demo = null;
        try {
            demo = Class.forName(name);
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
        return demo.getSimpleName();
    }
    /**
     * 同一段异常会被打印 2 次
     * 如果层次再复杂一点，不去考虑打印日志消耗的系统性能，仅仅在异常日志中去定位异常具体的问题已经够头疼的了。
     * 实际项目中具体我们可以分为两种情况：
     * ①如果调用者代码里，本身已有的业务逻辑里不会产生任何异常(不管是checked异常还是unchecked异常)，
     *  我们其实也无需再去捕获包含在其中别的方法的RuntimeException异常，就让产生异常的那个方法去打印日志
     * ②反之，比如这段代码里就包含了会产生异常的代码段(这里是手动抛出的unchecked异常)
     *  我们就把所有的捕获异常打印都放在该方法的catch里，那么它包含的方法中的那个还是去掉吧
     *  
     * 那么经过上面的描述 ，这里发生的情况应当如何做呢？
     * 这里我们可以把【getClassSimpleName】方法中的log日志打印去掉
     * @param name
     */
    public void getName(String name){
        try {
            if(!name.contains("a")){
                log.error("name:{}",name);
                throw new BizException("没有包含字母a");
            }
            
            String n = getClassSimpleName(name);
            System.out.println(n);
            
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args){
        CheckedClient4 client = new CheckedClient4();
        client.getName("com.somnus.exception.BizExceptioa");
        System.out.println("********************");
    }

}
