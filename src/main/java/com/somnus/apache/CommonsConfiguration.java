package com.somnus.apache;

import java.util.Iterator;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * @description: TODO
 * @author Somnus date 2015年4月1日 下午6:18:16
 */
public class CommonsConfiguration {
    public void configuration() {
        try {
            String url = getClass().getClassLoader().getResource("info.properties").getPath();
            System.out.println(url);
            PropertiesConfiguration config = new PropertiesConfiguration(url);
            config.setProperty("age", "22");
            config.save();

            Integer age = config.getInt("age");
            String password = config.getString("username");
            System.out.println(age);
            System.out.println(password);
            
            for(Iterator<String> it = config.getKeys();it.hasNext();){
                String key = (String)it.next();
                String value = config.getString(key);
                System.out.println(key +"="+value);
            }
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CommonsConfiguration config = new CommonsConfiguration();
        config.configuration();
    }
}
