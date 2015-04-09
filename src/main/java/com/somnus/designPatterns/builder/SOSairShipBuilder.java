package com.somnus.designPatterns.builder;

public class SOSairShipBuilder implements AirShipBuilder{

	@Override
	public OrbitaModule buildOrbitaModule() {
		System.out.println("构建SOS轨道舱");
		return new OrbitaModule("SOS轨道舱");
	}

	@Override
	public Engine buildEngine() {
		System.out.println("构建SOS发动机");
		return new Engine("SOS发动机");
	}

	@Override
	public EscapeTower buildEscapeTower() {
		System.out.println("构建SOS逃逸塔");
		return new EscapeTower("SOS逃逸塔");
	}

}
