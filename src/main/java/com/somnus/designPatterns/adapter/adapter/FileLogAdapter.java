package com.somnus.designPatterns.adapter.adapter;

import com.somnus.designPatterns.adapter.ILogTarget;
import com.somnus.designPatterns.adapter.log.FileLog;

public class FileLogAdapter extends FileLog implements ILogTarget {
	public void write(String log) {
		writeLog(log);
	}
}
