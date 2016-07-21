package com.somnus.http;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @Description: TODO
 * @author Somnus
 * @date 2015年12月16日 下午2:37:26
 * @version V1.0
 */
public class HttpClient {

    @Test
    public void doGet() {
        String url = "http://localhost:8080/SpringMVC/account/json";
        System.out.println(HttpUtils.doGet(url));
    }

    @Test
    public void doPost(){
        String url = "http://localhost:8080/SpringMVC/databind/json";
        Map<String,String> param = new HashMap<String, String>();
        param.put("username", "admin");
        param.put("password", "123456");
        System.out.println(HttpUtils.doPost(url, param));
    }
    
    @Test
    public void doPost1(){
    	String url = "http://restful.wozsz.com/service/com.somnus.resource.RestfulResource/getAccount";
        Map<String,String> param = new HashMap<String, String>();
        param.put("username", "admin");
        param.put("password", "123456");
        System.out.println(HttpUtils.doJsonPost(url, param));
    }
    
    @Test
    public void doPost2(){
    	String url = "http://restful.wozsz.com/service/com.somnus.resource.RestfulResource/getAccount2";
        Map<String,String> param = new HashMap<String, String>();
        param.put("username", "admin");
        param.put("password", "123456");
        System.out.println(HttpUtils.doXmlPost(url,param));
    }
}
