package com.somnus.designPatterns.chainOfResp;
/**
 * 抽象类
 * @author Smile
 *
 */
public abstract class Leader {
	protected String name;
	/* 责任链上的后继对象*/
	protected Leader nextLeader;
	public Leader(String name) {
		super();
		this.name = name;
	}
	public void setNextLeader(Leader nextLeader) {
		this.nextLeader = nextLeader;
	}
	public abstract void handleRequest(LeavRequest request);
}
