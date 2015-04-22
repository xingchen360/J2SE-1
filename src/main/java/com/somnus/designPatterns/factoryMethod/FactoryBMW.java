package com.somnus.designPatterns.factoryMethod;

interface FactoryBMW {
    BMW createBMW();
}  
  
class FactoryBMW320 implements FactoryBMW{
  
    @Override
    public BMW320 createBMW() {
  
        return new BMW320();
    }  
  
}  
class FactoryBMW523 implements FactoryBMW {
    @Override  
    public BMW523 createBMW() {
  
        return new BMW523();
    }
}