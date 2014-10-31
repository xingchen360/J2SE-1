package com.somnus.designPatterns.adapter.adapter;

import com.somnus.designPatterns.adapter.ILogTarget;
import com.somnus.designPatterns.adapter.log.DatabaseLog;

public class DatabaseLogAdapter extends DatabaseLog implements ILogTarget {
	public void write(String log) {
		writeLog(log);
	}
}
