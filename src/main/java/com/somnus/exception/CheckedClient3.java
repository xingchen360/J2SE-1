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
     * 但此处有个值得注意的地方，这里要本着【设计隔离原则】
     * 不能随意污染上层调用代码，什么样的异常不该在哪一层出现，这得开发人员自己把握
     * 比如dao层中的代码发生的异常，就不应该把异常传递到上层biz中，SQLException 会污染上层代码
     * 如果随意的，就不需要考虑这一点
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
