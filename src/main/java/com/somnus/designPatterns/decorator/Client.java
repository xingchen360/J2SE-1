package com.somnus.designPatterns.decorator;

public class Client{

	public static void main(String[] args){
		Car car = new Car();
		car.move();
		
		System.out.println("增加新的功能，飞行。。。。");
		FlyCar flycar = new FlyCar(car);
		flycar.move();
		
		System.out.println("增加新的功能，水里游。。。。");
		WaterCar wcar = new WaterCar(flycar);
		wcar.move();
	}
	
}
