package com.somnus.designPatterns.command;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Command command = new ConcreteCommand(new Receiver());
		Invoke Invoke = new Invoke(command);
		Invoke.call();
	}

}
