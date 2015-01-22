package com.somnus.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class FileInputStreamTest {

	public static void main(String[] args) {
		try {
			/*String fileName = "D:"+File.separator+"hello.txt";*/
			String fileName ="src/main/resources/build.xml";
			File f = new File(fileName);

			InputStream in = new FileInputStream(f);

			byte[] b = new byte[(int)f.length()];

			int len = in.read(b);
			//或者一个一个读
			/*
			for (int i = 0; i < b.length; i++) 
			{
	            b[i]=(byte)in.read();
	        }
	        System.out.println(new String(b));
	        */

			in.close();

			System.out.println("读入长度为："+len);

			System.out.println(new String(b,0,len));
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}