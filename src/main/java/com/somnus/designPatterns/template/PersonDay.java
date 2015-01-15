package com.somnus.designPatterns.template;

/** 
 * 模板方法设计模式中的“模板类” 
 * 一般情况下模板类都是一个抽象类 
 */  
public abstract class PersonDay {  
  
    /** 
     * 在模板方法中编写核心算法，这个算法是不会改变的，这个算法被子类继承，可以得到复用。 
     * 模板方法的流程一般不让子类覆盖，不希望子类去重新定义核心算法，所以模板方法通常被final修饰 
     */  
    public final void day(){  
        doGetUp();  
        doEatBreakfast();  
        doSome();  
        doSleep();  
    }  
      
    //将行为的具体实现延迟到子类中完成，达到不同的实现效果。  
    public abstract void doGetUp();  
    public abstract void doEatBreakfast();  
    public abstract void doSome();  
    public abstract void doSleep();  
}  