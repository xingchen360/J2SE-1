package com.somnus.apache;

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
            config.setProperty("age", "25");
            config.save();

            Integer integer = config.getInt("age");
            System.out.println(integer);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CommonsConfiguration config = new CommonsConfiguration();
        config.configuration();
    }
}
