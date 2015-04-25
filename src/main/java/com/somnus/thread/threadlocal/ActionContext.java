/**
 * 
 */
package com.somnus.thread.threadlocal;

/** 
 * @Title: ActionContext.java 
 * @Package com.somnus.thread.threadlocal 
 * @Description: TODO
 * @author Somnus
 * @date 2015年4月25日 上午10:40:32 
 * @version V1.0 
 */
public class ActionContext {
	private static final ThreadLocal<Index> local = new ThreadLocal<Index>();

	public Index getIndex() {
		return local.get();
	}
	public void setIndex(Index index){
		local.set(index);
	}
	private static ActionContext context ;
	
	private ActionContext(){}
	
	public static ActionContext getInstance(){
		if(context == null){
			context = new ActionContext();
		}
		return context;
	}
	
	public void remove(){
		local.remove();
	}

}
