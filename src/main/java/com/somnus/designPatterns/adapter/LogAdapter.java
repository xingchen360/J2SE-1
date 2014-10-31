package com.somnus.designPatterns.adapter;

import com.somnus.designPatterns.adapter.log.LogAdaptee;

public class LogAdapter implements ILogTarget {

	private LogAdaptee adaptee;

    public LogAdapter(LogAdaptee adaptee)
    {
        this.adaptee = adaptee;   
    }

    public void write(String log)
    {
    	adaptee.writeLog(log);
    }
}
