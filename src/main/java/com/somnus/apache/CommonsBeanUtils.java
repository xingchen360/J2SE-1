package com.somnus.apache;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * 
 * @Title: CommonsBeanUtils.java 
 * @Package com.somnus.apache 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月12日 下午5:38:24 
 * @version V1.0
 */
public class CommonsBeanUtils {
    
	public static void main(String[] args) throws Exception {
		// ****************************************************************************
		Person person = new Person();
		person.setName("tom");
		person.setAge(21);
		/*克隆对象*/
		Person person2 = (Person) BeanUtils.cloneBean(person);
		System.out.println("克隆对象>>" + person2);
		// ****************************************************************************
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "tom");
		map.put("email", "tom@");
		map.put("age", "21");
		/*将map转化为一个Person对象*/
		Person person3 = new Person();
		BeanUtils.populate(person3, map);
		System.out.println("将map转化为一个Person对象>>" + person3);
		/*通过上面的一行代码，此时person的属性就已经具有了上面所赋的值了。*/
		/*将一个Bean转化为一个Map对象了，如下：*/
		Map<String, String> map2 = BeanUtils.describe(person3);
		System.out.println(map2.get("name") + ">>" + map2.get("age"));
		/*拥有相同属性的对象转换*/
		People people = new People();
		BeanUtils.copyProperties(people, person);
		System.out.println("拥有相同属性的对象转换>>" + people);
		// ****************************************************************************
		Person person4 = new Person();
		person4.setName("andy");
		/*反射调用get方法*/
		String name = (String) PropertyUtils.getProperty(person4, "name");
		System.out.println(name);
		/*反射调用set方法*/
		PropertyUtils.setProperty(person4, "age", 25);
		System.out.println(person4.getAge());
	}
}
