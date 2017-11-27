package com.somnus.https;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

/**
 * @Description: https://api-vip1.huadata.com/result
 * @author Somnus
 * @date 2015年12月16日 下午2:37:26
 * @version V1.0
 */
public class HttpTest {
	
    @Test
    public void doJsonPost() throws Exception{
    	String url = "https://httpbin.org/post";
		JSONObject param = new JSONObject();
		param.put("username", "admin");
		param.put("password", "123456");
		System.out.println("body:" + HttpClientUtil.doJsonPost(url, param.toJSONString()));
    }
    
    @Test
    public void doJsonPostByFluent() throws ClientProtocolException, IOException {
    	String url = "https://httpbin.org/post";
    	JSONObject param = new JSONObject();
		param.put("username", "admin");
		param.put("password", "123456");
    	String response = Request.Post(url)
    						.connectTimeout(1000)
    						.socketTimeout(1000)  
    						.bodyString(param.toJSONString(),ContentType.APPLICATION_JSON)
    						.execute()
    						.returnContent()
    						.asString();
    	System.out.println(response);
    }
    
    @Test
    public void doPathParamGet() throws Exception {
    	String url = "https://httpbin.org/html";
		System.out.println("body:" + HttpClientUtil.doGet(url));
    }
    
    @Test
    public void doPathParamGetByFluent() throws ClientProtocolException, IOException {
    	String response = Request.Get("https://httpbin.org/html").execute()
				.returnContent().asString();
		System.out.println(response);
    }

    @Test
    public void doQueryParamGet() throws Exception {
    	String url = "https://httpbin.org/cookies/set";
		Map<String,String> param = new HashMap<String, String>();
		param.put("username", "admin");
		param.put("password", "123456");
		System.out.println("body:" + HttpClientUtil.doGet(url, param));
    }
    
    @Test
    public void doQueryParamGetByFluent() throws ClientProtocolException, IOException, URISyntaxException {
    	String url = "https://httpbin.org/cookies/set";
    	String response = Request.Get(new URIBuilder(url)
    									.addParameter("username", "admin")
    									.addParameter("password", "123456")
    									.build()
    								)
    					.execute().returnContent().asString();
		System.out.println(response);
    }

    @Test
    public void doFormParamPost() throws Exception{
    	String url = "https://httpbin.org/post";
		Map<String,String> param = new HashMap<String, String>();
		param.put("custname", "admin");
		param.put("custtel", "123456");
		System.out.println("body:" + HttpClientUtil.doPost(url, param));
    }
    
    @Test
    public void doFormParamPostByFluent() throws ClientProtocolException, IOException{
    	String url = "https://httpbin.org/post";
    	String response = Request.Post(url).bodyForm(Form.form()
    									.add("custname", "admin")
    									.add("custtel", "123456")
    									.build()
    							)
    					.execute().returnContent().asString();
    	System.out.println(response);
    }
    
    @Test
    public void doUpload() throws Exception {
    	String url = "http://localhost:8080/SpringMVC/databind/doUpload";
    	String path = Thread.currentThread().getContextClassLoader().getResource("excel/80034.xls").getPath();
    	System.out.println("body:" + HttpClientUtil.doUploadPost(url, new File(path)));
    }
    
    @Test
    public void doUploadByFluent() throws ClientProtocolException, IOException{
    	String url = "http://localhost:8080/SpringMVC/databind/doUpload";
    	String path = Thread.currentThread().getContextClassLoader().getResource("excel/80034.xls").getPath();
    	String response = Request.Post(url)
    					.body(MultipartEntityBuilder.create().addBinaryBody("file", new File(path)).build())
    					.execute().returnContent().asString();
    	System.out.println(response);
    }
    
    @Test
    public void doDownload() throws ClientProtocolException, IOException, URISyntaxException {
    	String url = "https://httpbin.org/image/jpeg";
    	byte[] buff = Request.Get(new URIBuilder(url).build()).execute().returnContent().asBytes();
    	OutputStream os = new FileOutputStream(new File("target/classes/e01.jpg"));
    	try {
			IOUtils.write(buff, os);
		} finally{
            IOUtils.closeQuietly(os);
        }
    }
}
