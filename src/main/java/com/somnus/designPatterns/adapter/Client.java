package com.somnus.designPatterns.adapter;

import com.somnus.designPatterns.adapter.adapter.DatabaseLogAdapter;
import com.somnus.designPatterns.adapter.adapter.FileLogAdapter;

public class Client {
	public static void main(String[] args) {
		ILogTarget dbLog = new DatabaseLogAdapter();
        dbLog.write("Logging Database...");
        
 
        ILogTarget fileLog = new FileLogAdapter();
        fileLog.write("Logging File...");
	}
}
