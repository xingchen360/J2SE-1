package com.somnus.json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class FastJsonUtil {
	/**
     * 简单序列化
     */
	@Test
    public void simpleTest() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123");
        user.setAge(20);
        User user2 = new User();
        user2.setUsername("admin2");
        user2.setPassword("123456");
        user2.setAge(24);
        List<Plot> list = Arrays.asList(new Plot("diudiu"),new Plot("dudu") );
        user.setList(list);
        Map<String,List<String>> map = new HashMap<String, List<String>>();
        map.put("somnus",Arrays.asList("1","2"));
        user.setMap(map);
        
        String jsonStr = JSON.toJSONString(user);
        System.out.println(jsonStr);
    }
	
	/**
     * 复杂序列化
     */
	@Test
    public void complexTest() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", "owen");
        map.put("age", 25);
        map.put("sex", "男");

        Map<String, Object> temp = new HashMap<String, Object>();
        temp.put("name", "jack");
        temp.put("age", 18);
        
        map.put("girinfo", temp);

        List<String> list = new ArrayList<String>();
        list.add("爬山");
        list.add("电影");
        list.add("旅游");
        
        map.put("hobby", list);

        String jsonStr = JSON.toJSONString(map);
        System.out.println(jsonStr);
    }
	
	/**
     * 日期序列化
     */
	@Test
    public void DateTest() {
        Date date = new Date();
        // 默认输出
        System.out.println("时间戳=" + JSON.toJSONString(date));
        // 默认的日期格式
        System.out.println("当前日期=" + JSON.toJSONString(date, SerializerFeature.WriteDateUseDateFormat));
        // 使用指定的日期格式
        System.out.println("当前日期=" + JSON.toJSONStringWithDateFormat(date, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat));
    }
	
	/**
     * 简单反序列化
     */
	@Test
    public void simpleDeserializeTest() {
        String jsonStr = "{\"username\":\"owen\",\"password\":\"passw0rd\", \"age\":24}";
        User user = JSON.parseObject(jsonStr, User.class);
        System.out.println(user);
    }
	
	/**
     * 泛型反序列化
     */
	@Test
    public void genericTypeDeserializeTest() {
        String jsonStr = "{\"user\":{\"username\":\"owen\",\"password\":\"passw0rd\", \"age\":24}}";
        Map<String, User> map = JSON.parseObject(jsonStr, new TypeReference<Map<String, User>>() {});
        System.out.println(map.get("user")+"\n");

        String jsonStr2 = "{\"user\":[{\"username\":\"owen\", \"age\":24}, {\"username\":\"jack\", \"age\":18}]";
        Map<String, List<User>> users = JSON.parseObject(jsonStr2, new TypeReference<Map<String, List<User>>>() {});
        for (User user : users.get("user")) {
        	System.out.println(user);
            System.out.println("------------------");
        }
    }
}
