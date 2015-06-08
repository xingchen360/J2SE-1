package com.somnus.xml;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 
 * @Title: Dom4jXpathDemo.java 
 * @Package com.somnus.xml 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月8日 上午11:32:19 
 * @version V1.0
 */
public class Dom4jXpathDemo {
    @SuppressWarnings("unchecked")
    public void parserXml(String fileName){
        SAXReader reader = new SAXReader();
        try {
            /*Document receiveDoc = DocumentHelper.parseText(result);*/
            Document document = reader.read(new File(fileName));
            /*System.out.println("name:"+document.selectSingleNode("/user/Account/name").getText());*/
            List<Element> list = document.selectNodes("/user/Account");
            for(Element el:list){
                System.out.println("Current parameterElement XPath: " + el.getPath());
                System.out.println("attribute type:"+el.attributeValue("type"));
                System.out.println("child name:"+el.elementText("name"));
                System.out.println("child code:"+el.elementText("name"));
                System.out.println("child pass:"+el.elementText("pass"));
                System.out.println("**********************************");
            }
            
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Dom4jXpathDemo demo = new Dom4jXpathDemo();
        demo.parserXml("src/main/resources/user.xml");
    }
}
