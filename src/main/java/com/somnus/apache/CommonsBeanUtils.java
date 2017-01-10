package com.somnus.apache;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.junit.Test;

/**
 * @Title: CommonsBeanUtils.java 
 * @Package com.somnus.apache 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月12日 下午5:38:24 
 * @version V1.0
 */
public class CommonsBeanUtils {
	
	static{
		BigDecimalConverter bdc = new BigDecimalConverter(null);
		ConvertUtils.register(bdc, java.math.BigDecimal.class);
		
		DateConverter dc = new DateConverter(null); 
		dc.setPattern("yyyy-MM-dd");
		//Date顺利被转换成String
		ConvertUtils.register(dc, String.class);
		//null可以用来正常转换
		ConvertUtils.register(dc, java.util.Date.class);
	}
    
    @Test
    public void cloneBean() throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException{
        Person person = new Person("admin","password",null,null);
        /*克隆对象*/
        Person person2 = (Person) BeanUtils.cloneBean(person);
        System.out.println("克隆对象>>" + person2);
    }
    
	@Test
    public void populate() throws IllegalAccessException, InvocationTargetException{
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", "tom");
        map.put("password", "tom@");
        map.put("birthday", "2016-10-01");
        map.put("high", "12");
        map.put("money", "100.00");
        /*将map转化为一个Person对象*/
        Person person = new Person();
        BeanUtils.populate(person, map);
        System.out.println("将map转化为一个Person对象>>" + person);
        
    }
	
	@Test
	public void describe() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
        Person person2 = new Person("admin","password",new Date(),null);
        /*将一个Bean转化为一个Map对象了，如下：*/
        Map<String, String> map2 = BeanUtils.describe(person2);
        System.out.println(map2.get("username") + ">>" + map2.get("birthday"));
	}
	
	@Test
	public void describe2() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
        Person person2 = new Person("admin","password",new Date(),null);
        /*将一个Bean转化为一个Map对象了，如下：*/
        Map<String, Object> map2 = PropertyUtils.describe(person2);
        System.out.println(map2.get("username") + ">>" + map2.get("birthday"));
	}
    
    @Test
    public void copyProperties() throws IllegalAccessException, InvocationTargetException{
        Person person = new Person("admin","password",new Date(),null);
        /*拥有相同属性的对象转换*/
        People people = new People();
        BeanUtils.copyProperties(people, person);
        System.out.println("拥有相同属性的对象转换>>" + people);
    }
    
    @Test
    public void reflect() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
        Person person = new Person("admin","password",null,null);
        /*反射调用get方法*/
        String username = (String) PropertyUtils.getProperty(person, "username");
        System.out.println(username);
        /*反射调用set方法*/
        PropertyUtils.setProperty(person, "high", 25.0);
        System.out.println(person);
    }
    
    @Test
    public void reflect2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{
        Person person = new Person("admin","password",null,null);
        MethodUtils.invokeMethod(person, "setUsername", new Object[] { "andy" });
        String name = (String) MethodUtils.invokeMethod(person, "getPassword", new Object[] { });
        System.out.println(name);
        System.out.println(person);
    }
}
