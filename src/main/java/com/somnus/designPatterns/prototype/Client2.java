package com.somnus.designPatterns.prototype;

import java.util.Date;

/**
 * 深克隆
 * @author Somnus
 */
public class Client2 {
	public static void main(String[] args) throws CloneNotSupportedException {
		Date date = new Date(1428588884432L);
		Sheep2 sheep = new Sheep2("Dolly",date);
		Sheep2 sheep2 = (Sheep2) sheep.clone();
		
		System.out.println(sheep);
		System.out.println(sheep.getName());
		System.out.println(sheep.getBirthday());
		
		date.setTime(1420588854432L);
		
		System.out.println(sheep2);
		System.out.println(sheep2.getName());
		System.out.println(sheep2.getBirthday());
	}
}
class Sheep2 implements Cloneable{
	private String name;
	private Date birthday;
	
	public Sheep2(String name, Date birthday) {
		this.name =  name;
		this.birthday = birthday;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException{
		Object obj = super.clone();
		
		//添加如下代码实现深复制
		Sheep2 s = (Sheep2) obj;
		s.birthday = (Date) this.birthday.clone();
		return obj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
