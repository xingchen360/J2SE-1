package com.somnus.designPatterns.bridge;

public abstract class AbstractCar {
    void run(){}; 
}

class Car extends AbstractCar{  
    @Override  
    void run() {  
        super.run();  
        System.out.print("小汽车");  
    }  
}

class Bus extends AbstractCar{  
    @Override  
    void run() {  
        super.run();  
        System.out.print("公交车");  
    }  
} 