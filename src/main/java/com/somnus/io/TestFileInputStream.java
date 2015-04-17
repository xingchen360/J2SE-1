package com.somnus.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class TestFileInputStream {

	public static void main(String[] args) {
		try {
			String fileName ="src/main/resources/build.xml";
			File f = new File(fileName);
			InputStream in = new FileInputStream(f);
			
			//一次性全部读出来
			byte[] b = new byte[(int)f.length()];
			System.out.println(b.length);
			int len = in.read(b,0,b.length);
			System.out.println("读入长度为："+len);
			System.out.println(new String(b));
			
			//或者一个一个读
			/*for (int i = 0; i < b.length; i++){
	            b[i]=(byte)in.read();
	        }
	        System.out.println(new String(b));*/
	        
			//或者分批读
			/*byte[] buff = new byte[128];
			int length = 0;
			while((length = in.read(buff,0,buff.length))!=-1){
				System.out.println(new String(buff,0,length));
			}*/

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}