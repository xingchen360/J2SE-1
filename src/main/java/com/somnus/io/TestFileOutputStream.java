package com.somnus.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TestFileOutputStream {
	/**
	 * 知道某个byte数组
	 * 往指定的目录生成文件
	 */
	public  void getFileFromBytes(byte[] bfile, String filePath, String fileName) 
	{
		try {
			File dir = new File(filePath);
			// 判断文件目录是否存在
			if (!dir.exists()) 
			{
				dir.mkdirs();
			}
			
			OutputStream os = new FileOutputStream(new File(filePath , fileName));
			
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			bos.write(bfile);
			
			bos.close();
			
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 知道指定的目录文件
	 * 从中读书byte数据
	 * 并且往另一目录文件写入相同的文件
	 */
	public  void getFileFromFile(String filePath, String fileName)
	{
		try
		{
			OutputStream os = new FileOutputStream(new File("src/main/resources/","test.txt"));
			BufferedOutputStream  bos = new BufferedOutputStream(os);
			
			InputStream is = new FileInputStream(new File(filePath , fileName));
			
			byte[] buffer = new byte[200];
			
			int len = 0;
			/*
			 * 从FileInputStream输入流中不断的读取byte数组
			 * 并且往被BufferedOutputStream包装的缓冲区写硬盘
			 */
			while((len = is.read(buffer)) > 0)
			{
				bos.write(buffer,0,len);
				System.out.println(new String(buffer,0,len));
			}
			/*
			byte[] b = new byte[(int)new File(filePath , fileName).length()];

		    int count = 0;

		    int temp = 0;

		    while((temp = is.read())!=(-1))
		    {
		          b[count++] = (byte)temp;
		          System.out.println((char)temp);
		    }
		    System.out.println(new String(b));
		    os.write(b);
			*/
			
			/*
			byte[] b = new byte[(int)new File(filePath , fileName).length()];

		    for (int i = 0; i < b.length; i++) 
			{
	            b[i] = (byte)is.read();
	            System.out.println((char)b[i]);
	        }
		    System.out.println(new String(b));
		    os.write(b);
			*/
			
			is.close();
			bos.close();
			os.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		TestFileOutputStream test = new TestFileOutputStream();
		test.getFileFromFile("src/main/resources/", "user.xml");
	}
}