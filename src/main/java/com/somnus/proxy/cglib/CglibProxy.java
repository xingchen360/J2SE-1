package com.somnus.proxy.cglib;

import java.io.Serializable;
import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @description: TODO
 * @author Somnus
 * @date 2015年3月9日 上午9:08:26
 */
public class CglibProxy implements MethodInterceptor, Serializable {
	private static final long serialVersionUID = 1L;

	private void doBefore() {
		System.out.println("before method invoke");
	}

	private void doAfter() {
		System.out.println("after method invoke");
	}

	public Object getProxy(Object target) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(this);
		enhancer.setClassLoader(target.getClass().getClassLoader());
		return enhancer.create();
	}
	
	public Object getProxy(Class<? extends Object> clazz){
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        enhancer.setInterfaces(new Class[] { Serializable.class });
        return enhancer.create();
	}
	

	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		try {
			// 调用之前
			doBefore();
			// 调用原始对象的方法
			Object result = proxy.invokeSuper(obj, args);
			// 调用之后
			doAfter();
			return result;
		} catch (Throwable e) {
			throw e;
		}
	}
}
