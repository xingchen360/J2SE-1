package com.somnus.designPatterns.chainOfResp;

public class GeneralManager  extends Leader{

	public GeneralManager(String name) {
		super(name);
		// TODO Auto-generated constructor stub
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
