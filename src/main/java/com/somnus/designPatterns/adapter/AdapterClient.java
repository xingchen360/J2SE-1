package com.somnus.designPatterns.adapter;

import com.somnus.designPatterns.adapter.log.DatabaseLog;
import com.somnus.designPatterns.adapter.log.FileLog;

public class AdapterClient {
	public static void main(String[] args) {
		ILogTarget dbLog = new LogAdapter(new DatabaseLog());
        dbLog.write("Logging Database...");

        ILogTarget fileLog = new LogAdapter(new FileLog());
        fileLog.write("Logging Database...");
	}
}
