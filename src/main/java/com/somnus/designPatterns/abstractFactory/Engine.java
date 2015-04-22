package com.somnus.designPatterns.abstractFactory;

//发动机以及型号    
public abstract class Engine {

}    
class EngineA extends Engine{
  public EngineA(){
      System.out.println("制造-->EngineA");
  }
}
class EngineB extends Engine{
  public EngineB(){
      System.out.println("制造-->EngineB");
  }
}