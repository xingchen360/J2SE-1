package com.somnus.designPatterns.chainOfResp;
/**
 * 
 * @Title: LeavRequest.java 
 * @Package com.somnus.designPatterns.chainOfResp 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月24日 下午5:25:21 
 * @version V1.0
 */
//请假单：请求类
public class LeavRequest {
	private String empName;
	private int leaveDays;
	private String reason;
	public LeavRequest(String empName, int leaveDays, String reason) {
		super();
		this.empName = empName;
		this.leaveDays = leaveDays;
		this.reason = reason;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getLeaveDays() {
		return leaveDays;
	}
	public void setLeaveDays(int leaveDays) {
		this.leaveDays = leaveDays;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
