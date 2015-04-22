package com.somnus.designPatterns.abstractFactory;

//空调以及型号
public abstract class Aircondition {

}

class AirconditionA extends Aircondition{ 
    public AirconditionA(){    
        System.out.println("制造-->AirconditionA"); 
    }
}

class AirconditionB extends Aircondition{
    public AirconditionB(){
        System.out.println("制造-->AirconditionB");
    }
}