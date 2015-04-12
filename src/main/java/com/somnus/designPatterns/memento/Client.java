package com.somnus.designPatterns.memento;

public class Client {

	public static void main(String[] args) {
		CareTaker taker = new CareTaker();
		Emp emp = new Emp("Somnus",25,10000.0);
		System.out.println("第一次打印的对象："+emp.getEname()+"|"+emp.getAge());
		taker.setEmpMemento(emp.memento());
		
		emp.setEname("Smile");
		emp.setAge(30);
		emp.setSalary(20000.0);
		System.out.println("第二次打印的对象："+emp.getEname()+"|"+emp.getAge());
		
		emp.recovery(taker.getEmpMemento());
		
		System.out.println("第三次打印的对象："+emp.getEname()+"|"+emp.getAge());
		
	}

}
