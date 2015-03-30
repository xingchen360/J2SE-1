package com.somnus.xml;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/** 
 * @description: TODO 
 * @author Somnus
 * date 2015年3月30日 下午4:01:43  
 */
public class Dom4jXpathDemo {
    @SuppressWarnings("unchecked")
    public void parserXml(String fileName){
        SAXReader reader = new SAXReader();
        try {
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
