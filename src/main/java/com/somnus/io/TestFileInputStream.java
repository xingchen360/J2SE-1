package com.somnus.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TestFileInputStream {

	public static void main(String[] args) throws IOException {
	    InputStream is = null;
        try {
            File f = new File("src/main/resources/build.xml");
            byte[] b = new byte[(int)f.length()];
            System.out.println("字节长度："+b.length);
            
            is = new FileInputStream(new File("src/main/resources/build.xml"));
            
            //一次性全部读出来
            /*int len = is.read(b,0,b.length);
            System.out.println("读入长度为："+len);
            System.out.println(new String(b));*/
            
            //或者一个一个读
            /*for (int i = 0; i < b.length; i++){
                b[i]=(byte)is.read();
                System.out.println(b[i]);
            }
            System.out.println(new String(b));*/
            
            //或者分批读
            byte[] buff = new byte[128];
            int length = 0;
            while((length = is.read(buff,0,buff.length))!=-1){
                System.out.println(new String(buff,0,length));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            is.close();
        }
	}
	
}