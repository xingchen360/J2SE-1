package com.somnus.xml;

public interface XmlDocument {
	/** 
	 *  定义XML文档建立与解析的接口 
	 * /
	
	/** 
	 *  @see 建立XML文档 
	 *  @param fileName 文件全路径名称
	 */
	public void createXml(String fileName)  throws Exception;

	/**
	 * @see 解析XML文档 
	 * @param fileName 文件全路径名称
	 */
	public void parserXml(String fileName)  throws Exception;
}
