package com.somnus.designPatterns.builder;

public class SOSairShipDirector implements AirShipDirector{
	private AirShipBuilder builder;
	
	public SOSairShipDirector(AirShipBuilder builder) {
		this.builder = builder;
	}

	public void setBuilder(AirShipBuilder builder) {
		this.builder = builder;
	}

	@Override
	public AirShip directAirShip() {
		Engine engine = builder.buildEngine();
		OrbitaModule o = builder.buildOrbitaModule();
		EscapeTower et = builder.buildEscapeTower();
		
		AirShip airship = new AirShip();
		airship.setEngine(engine);
		airship.setEscapeTower(et);
		airship.setOrbitaModule(o);
		
		return airship;
	}

}
