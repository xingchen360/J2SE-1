package com.somnus.designPatterns.builder;

public class Client {
	public static void main(String[] args) {
		AirShipDirector director = new SOSairShipDirector(new SOSairShipBuilder());
		AirShip ship = director.directAirShip();
		ship.launch();
	}
}