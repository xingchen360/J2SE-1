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
public class NoneActionContext {
	private Index local;

	public Index getIndex() {
		return local;
	}
	public void setIndex(Index index){
		this.local = index;
	}
	private static NoneActionContext context ;
	
	private NoneActionContext(){}
	
	public static NoneActionContext getInstance(){
		if(context == null){
			context = new NoneActionContext();
		}
		return context;
	}

}
