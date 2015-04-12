package com.somnus.designPatterns.state;

public class FreeState implements State{

	@Override
	public void handle() {
		// TODO Auto-generated method stub
		System.out.println("房间空闲，没人住");
	}

}
