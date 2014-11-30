package com.somnus.apache;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

public class CommonsBeanUtils {
	public static void main(String[] args) throws Exception {
		// ****************************************************************************
		Person person = new Person();
		person.setName("tom");
		person.setAge(21);
		// 克隆对象
		Person person2 = (Person) BeanUtils.cloneBean(person);
		System.out.println(person2.getName() + ">>" + person2.getAge());
		// ****************************************************************************
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "tom");
		map.put("email", "tom@");
		map.put("age", "21");
		// 将map转化为一个Person对象
		Person person3 = new Person();
		BeanUtils.populate(person3, map);
		System.out.println(person3.getName() + ">>" + person3.getAge());
		// 通过上面的一行代码，此时person的属性就已经具有了上面所赋的值了。
		// 将一个Bean转化为一个Map对象了，如下：
		Map<String, String> map2 = BeanUtils.describe(person3);
		System.out.println(map2.get("name") + ">>" + map2.get("age"));
		// ****************************************************************************
		Person person4 = new Person();
		person4.setName("andy");
		// 反射调用get方法
		String name = (String) PropertyUtils.getProperty(person4, "name");
		System.out.println(name);
		// 反射调用set方法
		PropertyUtils.setProperty(person4, "age", 25);
		System.out.println(person4.getAge());
	}
}
