package com.somnus.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @Title: UnCheckedClient2.java 
 * @Package com.somnus.exception 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月2日 上午11:23:14 
 * @version V1.0 
 */
public class UnCheckedClient2 {
    private transient Logger log = LoggerFactory.getLogger(this.getClass());
    
    /**
     * 遇到RuntimeException异常 你是声明一个抛出呢还是不声明呢
     * 我们到底要不要告诉它的调用者，我这里有一个异常可能要抛出
     * 答案是否定的，原因很简单
     * unchecked异常被设计为使用者不能够处理的异常，比如我写一个函数要求传入的参数是个正数，
     * 那么当我发现使用者传 了个负数进来时，合理的预期是程序中出bug了。
     * 如果我抛出一个异常描述这件事，
     * 即使我要求调用者捕获这个异常，
     * 他肯定也不知道该怎么办(总不能随便传一 个正数进来吧）。
     * @param age
     * @return
     */
    public String profile(int age) /*throws Exception*/{
        if(age<0||age>120){
            log.error("age:{}",age);
            throw new IllegalArgumentException("age must be (0<age<120)");
        }
        System.out.println("&&&&&&&&&&&&&&&&&&&&");
        return "年龄是：" + age + "岁";
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        UnCheckedClient2 client = new UnCheckedClient2();
        client.profile(-1);
        System.out.println("********************");
    }

}
