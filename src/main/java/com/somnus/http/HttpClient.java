package com.somnus.http;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.conn.HttpHostConnectException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.somnus.exception.HttpStatusException;

/**
 * @Description: TODO
 * @author Somnus
 * @date 2015年12月16日 下午2:37:26
 * @version V1.0
 */
public class HttpClient {
	
	private transient Logger		log = LoggerFactory.getLogger(this.getClass());
	
    @Test
    public void doJsonPost(){
    	try {
			String url = "http://restful.wozsz.com/service/com.somnus.resource.RestfulResource/getAccount";
			Map<String,String> param = new HashMap<String, String>();
			param.put("username", "admin");
			param.put("password", "123456");
			System.out.println("body:" + HttpClientUtils.doJsonPost(url, param));
		} catch (HttpStatusException e){
			log.error(e.getMessage(),e);
		} catch (HttpHostConnectException e) {
			log.error(e.getMessage(),e);
		} catch (IOException e) {
			log.error(e.getMessage(),e);
		}
    }
    
    @Test
    public void doXmlPost(){
    	try {
			String url = "http://restful.wozsz.com/service/com.somnus.resource.RestfulResource/getAccount2";
			Map<String,String> param = new HashMap<String, String>();
			param.put("username", "admin");
			param.put("password", "123456");
			System.out.println("body:" + HttpXMLUtils.doXmlPost(url, param));
		} catch (HttpStatusException e){
			log.error(e.getMessage(),e);
		} catch (HttpHostConnectException e) {
			log.error(e.getMessage(),e);
		} catch (IOException e) {
			log.error(e.getMessage(),e);
		}
    }
    
    @Test
    public void doPathParamGet() {
        try {
			String url = "http://restful.wozsz.com/service/com.somnus.resource.RestfulResource/getAccount3/admin/123456";
			System.out.println("body:" + HttpClientUtils.doGet(url));
		} catch (HttpStatusException e){
			log.error(e.getMessage(),e);
		}  catch (HttpHostConnectException e) {
			log.error(e.getMessage(),e);
		} catch (IOException e) {
			log.error(e.getMessage(),e);
		} catch (URISyntaxException e) {
			log.error(e.getMessage(),e);
		}
    }

    @Test
    public void doQueryParamGet() {
        try {
			String url = "http://restful.wozsz.com/service/com.somnus.resource.RestfulResource/getAccount4";
			Map<String,String> param = new HashMap<String, String>();
			param.put("username", "admin");
			param.put("password", "123456");
			System.out.println("body:" + HttpClientUtils.doGet(url, param));
		} catch (HttpStatusException e){
			log.error(e.getMessage(),e);
		}  catch (HttpHostConnectException e) {
			log.error(e.getMessage(),e);
		} catch (IOException e) {
			log.error(e.getMessage(),e);
		} catch (URISyntaxException e) {
			log.error(e.getMessage(),e);
		}
    }

    @Test
    public void doFormParamPost(){
        try {
			String url = "http://restful.wozsz.com/service/com.somnus.resource.RestfulResource/getAccount5";
			Map<String,String> param = new HashMap<String, String>();
			param.put("username", "admin");
			param.put("password", "123456");
			System.out.println("body:" + HttpClientUtils.doPost(url, param));
		} catch (HttpStatusException e){
			log.error(e.getMessage(),e);
		}  catch (HttpHostConnectException e) {
			log.error(e.getMessage(),e);
		} catch (IOException e) {
			log.error(e.getMessage(),e);
		}
    }
}
