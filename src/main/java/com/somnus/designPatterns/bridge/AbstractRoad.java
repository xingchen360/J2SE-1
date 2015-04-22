package com.somnus.designPatterns.bridge;

public abstract class AbstractRoad {
    AbstractCar aCar;  
    void run(){}; 
}

class Street extends AbstractRoad{  
    @Override  
    void run() {  
        super.run();  
        aCar.run();  
        System.out.println("在市区街道行驶");  
    }  
}

class SpeedWay extends AbstractRoad{  
    @Override  
    void run() {  
        super.run();  
        aCar.run();  
        System.out.println("在高速公路行驶");  
    }  
}  