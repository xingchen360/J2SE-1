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
					// 获取当前线程的本地变量，然后累加1000次
					Integer index = ActionContext.getInstance().getInteger();
					for (int i = 0; i < 1000; i++) {
						index++;
					}
					// 重新设置累加后的本地变量
					ActionContext.getInstance().setInteger(index);
					System.out.println(Thread.currentThread().getName() + " : " + index);
					ActionContext.getInstance().remove();
				}
			}, "Thread-" + j).start();
		}
	}
}
class ActionContext{
	private static ThreadLocal<ActionContext>	actionContext = new ThreadLocal<ActionContext>();
	
	private int integer ;

	public int getInteger() {
		return integer;
	}
	public void setInteger(int integer){
		this.integer = integer;
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
		actionContext.remove();
	}
}

class ActionContext2{
	
	private static ThreadLocal<Integer>	container = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return 0;
		}
	};

	public static Integer getInteger() {
		return container.get();
	}
	
	public static  void setInteger(Integer num){
		container.set(num);
	}
	
	public void remove(){
		container.remove();
	}
}
