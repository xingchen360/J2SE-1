package com.somnus.exception;

import java.util.HashMap;
import java.util.Map;

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
    
	private transient Logger log = LoggerFactory.getLogger(this.getClass());
    
    public void defined(String parameter){
        if(!"A".equals(parameter)){
            log.error("字母:{}",parameter);
            throw new BizException("只接收字母A");
        }
        System.out.println("&&&&&&&&&&&&&&&&&&&&");
    }
    /**
     * 当然还可以不去捕获异常信息进行打印
     * 我们都交给顶层方法
     */
    public void defined2(String parameter){
    	System.out.println("********************");
		defined(parameter);
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
			log.error(e.getMessage(),e);
			map.put("BUSINESS_ERROR", e.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			map.put("EXCEPTION_ERROR", ex.getMessage());
		}
    	return map;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
    	UnCheckedClient3 client = new UnCheckedClient3();
    	Map<String,Object> map = client.response();
    	System.out.println(map.get("BUSINESS_ERROR"));
    }

}
