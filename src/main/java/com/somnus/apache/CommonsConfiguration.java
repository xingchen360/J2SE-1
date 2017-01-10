package com.somnus.apache;

import java.util.Iterator;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.Test;

/**
 * 
 * @Title: CommonsConfiguration.java 
 * @Package com.somnus.apache 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月12日 下午5:39:14 
 * @version V1.0
 */
public class CommonsConfiguration {
    
	@Test
    public void properties() throws ConfigurationException {
    	String url = getClass().getClassLoader().getResource("info.properties").getPath();
        System.out.println(url);
        
        Configurations configs = new Configurations();
        Configuration config = configs.properties(url);
        
        config.setProperty("age", "22");
        
        System.out.println(config.getInt("age"));
        System.out.println(config.getString("username"));
        
        for(Iterator<String> it = config.getKeys();it.hasNext();){
            String key = (String)it.next();
            String value = config.getString(key);
            System.out.println(key +"="+value);
        }
    }

}
