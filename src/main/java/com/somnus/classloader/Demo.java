package com.somnus.classloader;

import java.io.IOException;
import java.io.InputStream;

/** 
 * @description: TODO 
 * @author Somnus
 * date 2015年4月1日 下午5:56:46  
 */
public class Demo {
    public  void print(){
        String url = getClass().getClassLoader().getResource("logback.xml").getPath();
        System.out.println(url);
        InputStream is = getClass().getClassLoader().getResourceAsStream("user.xml");
        try {
            int data = 0;
            while ((data=  is.read()) != -1)
            {
                System.out.print((char)data);
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.print();
    }
}
