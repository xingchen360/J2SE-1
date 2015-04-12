package com.somnus.designPatterns.adapter;
/**
 * 适配器
 * 相当于USB和PS/2的连接器
 * @author Smile
 *
 */
public class Adpater extends Adpatee implements Target{
	
	@Override
	public void handleReq() {
		super.request();
	}

}
