package com.somnus.poi;

/** 
 * @Description: TODO
 * @author Somnus
 * @date 2015年11月6日 上午11:41:28 
 * @version V1.0 
 */
public class People {
    private String name;
    private int age;
    public People() {
        super();
    }
    public People(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
