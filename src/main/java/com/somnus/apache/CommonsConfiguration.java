package com.somnus.apache;

import java.util.Iterator;

import org.apache.commons.configuration2.CompositeConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;

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
    
    public void configuration() {
    	String url = getClass().getClassLoader().getResource("info.properties").getPath();
        System.out.println(url);
        
        CompositeConfiguration config = new CompositeConfiguration(); 
        config.addConfiguration(new PropertiesConfiguration());
        
        /*PropertiesConfiguration config = new PropertiesConfiguration(url);
        config.setProperty("age", "22");
        config.save();*/

        Integer age = config.getInt("age");
        String password = config.getString("username");
        System.out.println(age);
        System.out.println(password);
        
        for(Iterator<String> it = config.getKeys();it.hasNext();){
            String key = (String)it.next();
            String value = config.getString(key);
            System.out.println(key +"="+value);
        }
    }

    public static void main(String[] args) throws ConfigurationException {
        CommonsConfiguration config = new CommonsConfiguration();
        config.configuration();
    }
}
