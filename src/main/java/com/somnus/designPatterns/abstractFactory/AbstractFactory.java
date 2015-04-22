package com.somnus.designPatterns.abstractFactory;

//创建工厂的接口    
public interface AbstractFactory {
  //制造发动机  
  public Engine createEngine();
  //制造空调   
  public Aircondition createAircondition();
}

//为宝马320系列生产配件    
class FactoryBMW320 implements AbstractFactory{
      
  @Override    
  public Engine createEngine() {
      return new EngineA();
  }    
  @Override    
  public Aircondition createAircondition() {
      return new AirconditionA();
  }
}

//宝马523系列  
class FactoryBMW523 implements AbstractFactory { 
  
  @Override    
  public Engine createEngine() {
      return new EngineB();
  }
  @Override    
  public Aircondition createAircondition() {
      return new AirconditionB();
  }

}
