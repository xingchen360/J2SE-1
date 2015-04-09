package com.somnus.designPatterns.builder;

public interface AirShipBuilder {
	OrbitaModule buildOrbitaModule();
	Engine buildEngine();
	EscapeTower buildEscapeTower();
}
