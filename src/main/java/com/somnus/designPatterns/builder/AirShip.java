package com.somnus.designPatterns.builder;

public class AirShip {
	/* 轨道舱*/
	private OrbitaModule orbitaModule;
	/* 发动机*/
	private Engine engine;
	/* 逃逸塔*/
	private EscapeTower escapeTower;
	
	protected void launch(){
		System.out.println("点火，发射。。。。");
	}
	
	public OrbitaModule getOrbitaModule() {
		return orbitaModule;
	}
	public void setOrbitaModule(OrbitaModule orbitaModule) {
		this.orbitaModule = orbitaModule;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public EscapeTower getEscapeTower() {
		return escapeTower;
	}
	public void setEscapeTower(EscapeTower escapeTower) {
		this.escapeTower = escapeTower;
	}
	
}
class OrbitaModule{
	private String name;
	public OrbitaModule(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
class Engine{
	private String name;
	public Engine(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
class EscapeTower{
	private String name;
	public EscapeTower(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}