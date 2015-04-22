package com.somnus.designPatterns.bridge;

public class Client {

    public static void main(String[] args) {
        AbstractRoad speedWay = new SpeedWay();  
        speedWay.aCar = new Car();  
        speedWay.run();  
          
        AbstractRoad street = new Street();  
        street.aCar = new Bus();  
        street.run();
    }

}
