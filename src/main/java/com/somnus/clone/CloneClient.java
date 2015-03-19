package com.somnus.clone;

public class CloneClient {

	public static void main(String[] args) throws CloneNotSupportedException {
		Student student = new Student();
		student.setName("lily");
		
		Teacher teacher = new Teacher();
		teacher.setName("cici");
		
		student.setTeacher(teacher);
		
		Student student2 = (Student) student.clone();
		
		System.out.println(student2.getName());
		System.out.println(student2.getTeacher().getName());
		System.out.println(student == student2);
		System.out.println(student.getClass()==student2.getClass());
	}

}
class Student implements Cloneable{
	private String name;
	
	private Teacher teacher;

	public String getName() {
		return name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public Object clone() throws CloneNotSupportedException{
		Object object = super.clone();
		return object;
	}
}
class Teacher implements Cloneable{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public Object clone() throws CloneNotSupportedException{
		Object object = super.clone();
		return object;
	}
}
