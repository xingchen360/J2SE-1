package com.somnus.designPatterns.adapter.log;


public class DatabaseLog extends LogAdaptee {
	public void writeLog(String log) {
		System.out.println(log);
	}
}
