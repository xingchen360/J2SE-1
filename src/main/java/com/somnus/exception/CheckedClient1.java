package com.somnus.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @Title: CheckedClient1.java 
 * @Package com.somnus.exception 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月2日 上午11:23:14 
 * @version V1.0 
 */
public class CheckedClient1 {
    private static final Logger log = LoggerFactory.getLogger(CheckedClient1.class);
    
    /**
     * Exception 异常
     * checked异常  需要try catch
     * 如果你的业务逻辑中是有该异常情况，而且你希望后面的代码不应该继续执行，就new 出 RuntimeException
     * 这样后面的代码都将不会执行
     * 如果不想处理，就不要try catch了，直接在方法上throws 出去
     * CheckedClient3 有说明
     * @param name
     * @return
     */
    public String getClassSimpleName(String name) /*throws Exception*/{
        Class<?> demo = null;
        try {
            demo = Class.forName(name);
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage(), e);
            /* 把异常信息封装成一个新的RuntimeException传递给它的调用者
             * 实际项目中 可能还会碰到【throw e】这种情况
             * ①如果自己处理完后你想被调用者继续处理该异常，或者需要把该种异常传播到最终调用者，就使用throw e，当然方法上还需要声明
             * ②如果自己处理完后，并不需要被调用者处理，直接中断，那么就使用【throw new RuntimeException(e)】
             */
            throw new RuntimeException(e);/*throw e;*/
        }
        System.out.println("&&&&&&&&&&&&&&&&&&&&&");
        return demo.getSimpleName();
    }

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args){
        CheckedClient1 client = new CheckedClient1();
        client.getClassSimpleName("com.somnus.exception.BizExceptio");
        System.out.println("********************");
    }
}
