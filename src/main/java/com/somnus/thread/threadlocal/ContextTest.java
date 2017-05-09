package com.somnus.thread.threadlocal;

/** 
 * @Title: ActionContext.java 
 * @Package com.somnus.thread.threadlocal 
 * @Description: TODO
 * @author Somnus
 * @date 2015年4月25日 上午10:40:32 
 * @version V1.0 
 */
public class ContextTest {
	public static void main(String[] args) {
		for (int j = 0; j < 10; j++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					ActionContext.getInstance().setIndex(new Index());
					// 获取当前线程的本地变量，然后累加1000次
					Index index = ActionContext.getInstance().getIndex();
					for (int i = 0; i < 1000; i++) {
						index.increase();
					}
					// 重新设置累加后的本地变量
					ActionContext.getInstance().setIndex(index);
					System.out.println(Thread.currentThread().getName() + " : " + index.num);
					ActionContext.getInstance().remove();
				}
			}, "Thread-" + j).start();
		}
	}
}
class ActionContext{
	private static ThreadLocal<ActionContext> actionContext = new ThreadLocal<ActionContext>();
	
	private static final ThreadLocal<Index> 		local = new ThreadLocal<Index>();

	public Index getIndex() {
		return local.get();
	}
	public void setIndex(Index index){
		local.set(index);
	}
	
	private ActionContext(){}
	
	public static ActionContext getInstance(){
		ActionContext context = actionContext.get();
    	if(context == null){
    		context = new ActionContext();
    		actionContext.set(context);
    	}
        return context;
    }
	
	public void remove(){
		local.remove();
	}
}
