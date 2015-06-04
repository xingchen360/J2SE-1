package com.somnus.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @Title: UnCheckedClient1.java 
 * @Package com.somnus.exception 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月2日 上午11:23:14 
 * @version V1.0 
 */
public class UnCheckedClient1 {
    private transient Logger log = LoggerFactory.getLogger(this.getClass());
    
    /**
     * 自定义 RuntimeException 
     * unchecked异常  不需要try catch
     * 在处理业务逻辑的时候需要new出这种异常的时候 ，最好前面加个error日志
     * 加log的原因是要告诉开发者现有的流程有问题，不应该走下去了，并且把异常产生的条件(参数)打印出来
     * 
     * @param parameter
     * @return
     */
    public void defined(String parameter){
        if(!"A".equals(parameter)){
            log.error("字母:{}",parameter);
            throw new BizException("只接收字母A");
        }
        System.out.println("&&&&&&&&&&&&&&&&&&&&");
    }
    

    /**
     * @param args
     */
    public static void main(String[] args) {
        UnCheckedClient1 client = new UnCheckedClient1();
        client.defined("B");
        System.out.println("********************");
    }

}
