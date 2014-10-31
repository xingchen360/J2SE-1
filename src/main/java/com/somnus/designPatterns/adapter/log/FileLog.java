package com.somnus.designPatterns.adapter.log;


public class FileLog extends LogAdaptee {
	public void writeLog(String log) {
		System.out.println(log);
	}
}
