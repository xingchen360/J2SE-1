package com.somnus.designPatterns.mediator;

public interface Mediator {
	void register(String dname,Department dept);
	
	void command(String dname);
}
