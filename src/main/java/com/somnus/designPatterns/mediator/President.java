package com.somnus.designPatterns.mediator;

import java.util.HashMap;
import java.util.Map;

public class President implements Mediator{
	
	private Map<String, Department> map = new HashMap<String, Department>();

	@Override
	public void register(String dname, Department dept) {
		// TODO Auto-generated method stub
		map.put(dname, dept);
	}

	@Override
	public void command(String dname) {
		// TODO Auto-generated method stub
		map.get(dname).selfAction();
	}

}
