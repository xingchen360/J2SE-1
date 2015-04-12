package com.somnus.designPatterns.adapter;
/**
 * 相当于笔记本
 * @author Smile
 *
 */
public class Client {
	public void test(Target target){
		target.handleReq();
	}
	public static void main(String[] args) {
		Client client = new Client();
		
		/*Adpatee adpatee = new Adpatee();*/
		
		Target target = new Adpater();
		
		client.test(target);
	}
}
