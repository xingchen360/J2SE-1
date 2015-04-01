package com.somnus.apache;

/** 
 * @description: TODO 
 * @author Somnus
 * date 2015年4月1日 下午6:18:16  
 */
public class CommonsConfiguration {
    public static void main(String[] args) {
        PropertiesConfiguration config = new PropertiesConfiguration("src/main/resources/info.properties");  
        config.setProperty("age", "21");  
        config.save();  
          
        Integer integer = config.getInteger("age");
        
        System.out.println(integer);
    }
}
