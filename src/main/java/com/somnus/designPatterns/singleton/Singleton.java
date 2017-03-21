package com.somnus.designPatterns.singleton;
/**
 * 如何选用
 * 	单例对象 占用资源少，不需要延时加载
 * 		枚举式 好于 饿汉式
 * 	单例对象 占用资源多，需要延时加载
 * 		静态内部类 式 好于 懒汉式
 */

//懒汉式1【线程安全，调用效率不高，但是，可以延时加载】
public class Singleton{
	private static Singleton instance ;
	
	private Singleton(){}
	
	public static Singleton getInstance(){
		if(instance == null){
			instance = new Singleton();
		}
		return instance;
	}
}

//懒汉式2
class Singleton2{
	private static Singleton2 instance ;
  
	private Singleton2(){}
  
	public static synchronized Singleton2 getInstance(){
		if(instance == null){
			instance = new Singleton2();
		}
		return instance;
	}
}

//懒汉式3
class Singleton3{
	private static Singleton3 instance ;
  
	private Singleton3(){}
  
	public static Singleton3 getInstance(){
		if(instance == null){
			synchronized (Singleton3.class) {  
				instance = new Singleton3();   
			} 
		}
		return instance;
	}
}

//静态(static)内部类【线程安全，调用效率高，但是，可以延时加载】
class Singleton6{
	private Singleton6(){}

	private static class HolderClass {
		private final static Singleton6 instance = new Singleton6();
	}
	        
	public static Singleton6 getInstance() {
		return HolderClass.instance;
	}
}

//饿汉式【线程安全，调用效率不高，但是，不能延时加载】
class Singleton5{
	//类初始化时，立即加载这个对象（没有延时加载的优势），加载类时，天然是线程安全的
	private static Singleton5 instance = new Singleton5();
	
	private Singleton5(){}
	
	//方法没有同步，调用效率高
	public static Singleton5 getInstance(){
		return instance;
	}
}

//枚举式【线程安全，调用效率高，但是，不能延时加载】
enum Singleton7{
	
	INSTANCE;
	
	private Singleton7(){}
	
	public void opreate(){
		
	}
}


//双重检测锁【由于JVM底层内部模型原因，偶尔会出现问题，不建议使用】
class Singleton4{
    private static Singleton4 instance ;
    
    private Singleton4(){}
    
    public static Singleton4 getInstance(){
        //第一重判断  
        if (instance == null) {
            //锁定代码块  
            synchronized (Singleton4.class) {
                //第二重判断  
                if (instance == null) {
                    instance = new Singleton4(); //创建单例实例  
                }
            }
        }
        return instance;
    }
}
