package com.somnus.designPatterns.memento;
/**
 * 备忘录类
 * @author Smile
 *
 */
public class EmpMemento {
	private String ename;
	private int age;
	private double salary;
	
	public EmpMemento(Emp emp) {
		super();
		this.ename = emp.getEname();
		this.age = emp.getAge();
		this.salary = emp.getSalary();
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
