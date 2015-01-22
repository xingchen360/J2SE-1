package com.somnus.io;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class TestByteArrayOutputStream {

	public static void main(String[] args) throws Exception {
		ByteArrayOutputStream bos= new ByteArrayOutputStream();
		
		//知道byte数组，往ByteArrayOutputStream组织数据
		byte[] buffer = "hello world".getBytes();
		/*
		 * ByteArrayOutputStream输出流的write方法只是把byte数组组织进去
		 * 不会往硬盘执行写
		 */
		bos.write(buffer);
		
		//可以把ByteArrayOutputStream输出流变成byte数组
		byte[] result =bos.toByteArray();

		for (int i = 0; i < result.length; i++) 
		{
			System.out.println((char) result[i]);
		}
		
		//A
		OutputStream os = new FileOutputStream("src/main/resources/test.txt");
		bos.writeTo(os);
		
		//B
		os.write(result);//知道byte数组数据      往硬盘写入数据 没必要再转一次
		
		//C包装一个管道缓冲区
		BufferedOutputStream buffos = new BufferedOutputStream(os);
		buffos.write(result);

		bos.close();
		os.close();
		buffos.close();

	}

	/**
	 * 根据指定目录文件
	 * 获得指定文件的byte数组
	 */
	public static byte[] getBytesFromFile(String filePath, String fileName) 
	{
		byte[] buffer = null;
		try 
		{
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			
			InputStream is = new FileInputStream(new File(filePath , fileName));
			
			byte[] b = new byte[1000];
			
			int len = 0;;
			
			/*
			 * 读取FileInputStream的输入流到ByteArrayOutputStream中
			 * 是为了得到byte数组
			 */
			while ((len = is.read(b,0,1000)) != -1) 
			{
				/*
				 * ByteArrayOutputStream的write方法只是把byte数组组织进去
				 * 不会往硬盘执行写
				 */
				bos.write(b, 0, len);
			}
			
			buffer = bos.toByteArray();
			
			is.close();
			
			bos.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return buffer;
	}
}