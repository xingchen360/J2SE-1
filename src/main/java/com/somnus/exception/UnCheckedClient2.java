package com.somnus.exception;

import java.util.HashMap;
import java.util.Map;

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
    
    public void defined(String parameter){
        if(!"A".equals(parameter)){
            log.error("字母:{}",parameter);
            throw new BizException("只接收字母A");
        }
        System.out.println("&&&&&&&&&&&&&&&&&&&&");
    }
    
    /**
     * 这里之所以继续抛，并不是希望顶层方法对其异常进行补救处理
     * 我们并不是去要违反这个原则(unchecked就是被设计成不能够处理的异常)
     * 
     * 但为什么打印完日志后，还继续抛出呢，这是因为顶层代码需要这个异常的信息反馈出去，仅此而已
     * 
     */
    public void defined2(String parameter){
    	System.out.println("********************");
		try {
			defined(parameter);
		} catch (BizException e) {
			log.error(e.getMessage(), e);
			throw e;
		}
		System.out.println("====================");
    }
    
    /**
     * 顶层方法
     */
    public Map<String,Object> response(){
    	Map<String,Object> map = new HashMap<String,Object>();
    	try {
			defined2("B");
			System.out.println("********************");
		} catch (BizException e) {
			map.put("BUSINESS_ERROR", e.getMessage());
		} catch (Exception ex) {
			map.put("EXCEPTION_ERROR", ex.getMessage());
		}
    	return map;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
    	UnCheckedClient2 client = new UnCheckedClient2();
    	Map<String,Object> map = client.response();
    	System.out.println(map.get("BUSINESS_ERROR"));
    }

}
