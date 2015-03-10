package com.somnus.cglib;

/** 
 * @description: TODO 
 * @author Somnus
 * @date 2015年3月9日 上午9:05:41  
 */
public class CglibClient {
	public static void main(String[] args) {
		ProxyObject obj = new ProxyObject();
		CglibProxy cglib = new CglibProxy();
		ProxyObject proxy = (ProxyObject)cglib.getProxy(obj);
		proxy.doSomething();
		
		
		ProxyObject proxy2 = (ProxyObject)cglib.getProxy(ProxyObject.class);
		proxy2.doSomething();
	}
}
