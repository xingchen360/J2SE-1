package com.somnus.designPatterns.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 使用序列化和反序列化实现深克隆
 * @author Somnus
 */
public class Client3 {
	public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
		Date date = new Date(1428588884432L);
		Sheep sheep = new Sheep("Dolly",date);
		
		System.out.println(sheep);
		System.out.println(sheep.getName());
		System.out.println(sheep.getBirthday());
		
		/*Sheep Sheep2 = (Sheep) sheep.clone();*/
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(sheep);
		byte[] buff = bos.toByteArray();
		
		ByteArrayInputStream bis = new ByteArrayInputStream(buff);
		ObjectInputStream ois = new ObjectInputStream(bis);
		Sheep Sheep2 = (Sheep) ois.readObject();
		
		//修改原型对象的属性值
		date.setTime(1420588854432L);
		System.out.println(sheep.getBirthday());
		
		System.out.println(Sheep2);
		System.out.println(Sheep2.getName());
		System.out.println(Sheep2.getBirthday());
	}
}
