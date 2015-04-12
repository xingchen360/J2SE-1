package com.somnus.designPatterns.chainOfResp;

public class Client {

	public static void main(String[] args) {
		Leader a = new Director("Somnus");
		Leader b = new Manager("Smile");
		Leader c = new GeneralManager("Sunshine");
		
		/*组织责任链对象的关系*/
		a.setNextLeader(b);
		b.setNextLeader(c);
		
		LeavRequest req = new LeavRequest("tom",10,"回家");
		a.handleRequest(req);
	}

}
