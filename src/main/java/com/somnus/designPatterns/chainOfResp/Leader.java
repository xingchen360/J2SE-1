package com.somnus.designPatterns.chainOfResp;
/**
 * 
 * @Title: Leader.java 
 * @Package com.somnus.designPatterns.chainOfResp 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月24日 下午5:21:58 
 * @version V1.0
 */
//审批者类：抽象处理者
public abstract class Leader {
	protected String name;
	/* 责任链上的后继对象*/
	protected Leader nextLeader;
	public Leader(String name) {
		this.name = name;
	}
	//设置后继者 
	public void setNextLeader(Leader nextLeader) {
		this.nextLeader = nextLeader;
	}
	public abstract void handleRequest(LeavRequest request);
}
//主任类：具体处理者
class Director extends Leader{

    public Director(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeavRequest request) {
        if(request.getLeaveDays()<3){
            System.out.println("员工："+request.getEmpName()+"请假，天数："+request.getLeaveDays()+",理由："+request.getReason());
            System.out.println("主任："+this.name+"审批通过");
        }else{
            if(this.nextLeader!=null){
                this.nextLeader.handleRequest(request);
            }
        }
    }
}
//总经理类：具体处理者
class Manager extends Leader{

    public Manager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeavRequest request) {
        if(request.getLeaveDays()<10){
            System.out.println("员工："+request.getEmpName()+"请假，天数："+request.getLeaveDays()+",理由："+request.getReason());
            System.out.println("经理："+this.name+"审批通过");
        }else{
            if(this.nextLeader!=null){
                this.nextLeader.handleRequest(request);
            }
        }
    }
}
//总经理类：具体处理者
class GeneralManager  extends Leader{

    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeavRequest request) {
        if(request.getLeaveDays()<30){
            System.out.println("员工："+request.getEmpName()+"请假，天数："+request.getLeaveDays()+",理由："+request.getReason());
            System.out.println("总经理："+this.name+"审批通过");
        }else{
            System.out.println("莫非"+request.getEmpName()+"请假超过"+request.getLeaveDays()+"想辞职");
        }
    }
}