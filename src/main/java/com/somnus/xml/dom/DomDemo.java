package com.somnus.xml.dom;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomDemo {
	public void createXml(String fileName) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.newDocument();
		
		Element root = document.createElement("user");
		document.appendChild(root);
		
		//*******设置第一个********
		Element accountElement = document.createElement("Account");
		accountElement.setAttribute("type", "mobile");
		
		Element name = document.createElement("name");
		name.appendChild(document.createTextNode("移动"));
		accountElement.appendChild(name);
		
		Element code = document.createElement("code");
		code.appendChild(document.createTextNode("10086"));
		accountElement.appendChild(code);
		
		Element pass = document.createElement("pass");
		pass.appendChild(document.createTextNode("123456"));
		accountElement.appendChild(pass);
		
		Element money = document.createElement("money");
		money.appendChild(document.createTextNode("999999999"));
		accountElement.appendChild(money);
		root.appendChild(accountElement);
		
		//设置第二个
		Element accountElement2 = document.createElement("Account");
		accountElement2.setAttribute("type", "unicom");
		
		Element name2 = document.createElement("name");
		name2.appendChild(document.createTextNode("联通"));
		accountElement2.appendChild(name2);
		
		Element code2 = document.createElement("code");
		code2.appendChild(document.createTextNode("10010"));
		accountElement2.appendChild(code2);
		
		Element pass2 = document.createElement("pass");
		pass2.appendChild(document.createTextNode("123456"));
		accountElement2.appendChild(pass2);
		
		Element money2 = document.createElement("money");
		money2.appendChild(document.createTextNode("88888888"));
		accountElement2.appendChild(money2);
		root.appendChild(accountElement2);
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		DOMSource source = new DOMSource(document);
		transformer.setOutputProperty(OutputKeys.ENCODING, "gb2312");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
		StreamResult result = new StreamResult(pw);
		transformer.transform(source, result);
	}

	public void parserXml(String fileName) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); // 返回documentBuilderFactory对象

		DocumentBuilder db = dbf.newDocumentBuilder();// 返回db对象用documentBuilderFatory对象获得返回documentBuildr对象

		Document dt = db.parse(new File(fileName)); // 得到一个DOM并返回给document对象

		Element root = dt.getDocumentElement();// 得到一个elment根元素

		System.out.println("根元素：" + root.getNodeName()); // 获得根节点

		NodeList childNodes = root.getChildNodes(); // 获得根元素下的子节点

		for (int i = 0; i < childNodes.getLength(); i++) { // 遍历这些子节点

			Node node = childNodes.item(i); // childNodes.item(i); 获得每个对应位置i的结点

			if ("Account".equals(node.getNodeName())) {// 如果节点的名称为"Account"，则输出Account元素属性type

				System.out.println("属性-所属区域: "+ node.getAttributes().getNamedItem("type").getNodeValue());

				NodeList nodeDetail = node.getChildNodes(); // 获得<Accounts>下的节点

				for (int j = 0; j < nodeDetail.getLength(); j++) { // 遍历<Accounts>下的节点

					Node detail = nodeDetail.item(j); // 获得<Accounts>元素每一个节点

					if ("code".equals(detail.getNodeName())) // 输出code
					{
						System.out.println("卡号: " + detail.getTextContent());
					} else if ("pass".equals(detail.getNodeName())) // 输出pass
					{
						System.out.println("密码: " + detail.getTextContent());
					} else if ("name".equals(detail.getNodeName())) // 输出name
					{
						System.out.println("姓名: " + detail.getTextContent());
					} else if ("money".equals(detail.getNodeName())) // 输出money
					{
						System.out.println("余额: " + detail.getTextContent());
					}
				}
			}
		}
	}
}
