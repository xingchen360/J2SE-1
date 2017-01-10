package com.somnus.xml;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Comment;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.junit.Test;

/**
 * 
 * @Title: JdomDemo.java 
 * @Package com.somnus.xml 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月8日 上午11:32:50 
 * @version V1.0
 */
public class JdomDemo {
	
	@Test
	public void test1() throws JDOMException, IOException{
		SAXBuilder bulider = new SAXBuilder();
		Document doc = bulider.build(getClass().getClassLoader().getResourceAsStream("user.xml"));
		//获得根节点
		Element root = doc.getRootElement();
		/*List<Element> list = root.getChildren("Account");*/
		for(Iterator<Element> it = root.getChildren().iterator(); it.hasNext();){
			Element element = it.next();
			System.out.println("属性-所属区域: "+ element.getAttributeValue("type"));
			List<Attribute> listatr = element.getAttributes();
			//循环遍历属性
			for(Attribute data:listatr)
			{
				System.out.println("属性:" + data.getName()+" = " + data.getValue());
			}
			for(Iterator<Element> child = element.getChildren().iterator(); child.hasNext();)
			{
				Element el = child.next();
				System.out.println(el.getName() + " : " + el.getText());
			}
			System.out.println("*************************************");
		}
	}
    
	public void createXml(String fileName)  throws Exception{
		Document document = new Document();
		
		Element rootElement = new Element("user");
		document.addContent(rootElement);
		
		Comment comment = new Comment("注释");
		rootElement.addContent(comment);
		
		//*******设置第一个********
		Element accountElement = new Element("Account");
		accountElement.setAttribute("type","mobile");
		rootElement.addContent(accountElement);
		
		Element name = new Element("name");
		name.setText("移动");
		accountElement.addContent(name);
		
		Element code = new Element("code");
		code.setText("10086");
		accountElement.addContent(code);
		
		Element pass = new Element("pass");
		pass.setText("123456");
		accountElement.addContent(pass);
		
		Element money = new Element("money");
		money.setText("999999999");
		accountElement.addContent(money);
		
		//*******设置第二个********
		Element accountElement2 = new Element("Account");
		accountElement2.setAttribute("type","unicom");
		rootElement.addContent(accountElement2);
		
		Element name2 = new Element("name");
		name2.setText("联通");
		accountElement2.addContent(name2);
		
		Element code2 = new Element("code");
		code2.setText("10010");
		accountElement2.addContent(code2);
		
		Element pass2 = new Element("pass");
		pass2.setText("123456");
		accountElement2.addContent(pass2);
		
		Element money2 = new Element("money");
		money2.setText("88888888");
		accountElement2.addContent(money2);
		
		XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
		
		out.output(document, new FileOutputStream(fileName));
		
	}
}
