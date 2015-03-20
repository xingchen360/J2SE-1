package com.somnus.clone;

public class CloneClient {

	public static void main(String[] args) throws CloneNotSupportedException {
		Student student = new Student();
		student.setName("lily");
		
		Teacher teacher = new Teacher();
		teacher.setName("cici");
		
		student.setTeacher(teacher);
		
		Student student2 = (Student) student.clone();
		student2.setName("tom");
		student2.getTeacher().setName("marry");
		
		System.out.println(student.getName());
		System.out.println(student.getTeacher().getName());
		
		System.out.println(student2.getName());
		System.out.println(student2.getTeacher().getName());
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
	    /*//浅拷贝
		Object object = super.clone();
		return object;*/
	    // 改为深拷贝：
        Student student = (Student) super.clone();
        // 本来是浅拷贝，现在将Teacher对象复制一份并重新set进来
        student.setTeacher((Teacher) student.getTeacher().clone());
        return student;
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
