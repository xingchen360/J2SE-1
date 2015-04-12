package com.somnus.designPatterns.memento;

public class Emp {
	private String ename;
	private int age;
	private double salary;
	
	/*进行备忘操作，并返回备忘录对象*/
	public EmpMemento memento(){
		return new EmpMemento(this);
	}
	
	public void recovery(EmpMemento emt){
		this.ename = emt.getEname();
		this.age = emt.getAge();
		this.salary = emt.getSalary();
	}
	
	public Emp(String ename, int age, double salary) {
		super();
		this.ename = ename;
		this.age = age;
		this.salary = salary;
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
