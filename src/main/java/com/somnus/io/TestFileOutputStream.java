package com.somnus.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TestFileOutputStream {
	/**
	 * 知道某个byte数组
	 * 往指定的目录生成文件
	 * @throws IOException 
	 * @throws Exception 
	 */
	public void getFileFromBytes(byte[] bfile, String filePath, String fileName) throws IOException{
	    OutputStream os = null;
        try {
            os = new FileOutputStream(new File(filePath , fileName));
            os.write(bfile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        os.close();
	}
	
	/**
	 * 知道指定的目录文件
	 * 从中读书byte数据
	 * 并且往另一目录文件写入相同的文件
	 * @throws IOException 
	 */
	public void getFileFromFile(String filePath, String fileName) throws IOException{
	    OutputStream os = null;
        InputStream is = null;
        try {
            os = new FileOutputStream(new File("target/classes/test.txt"));
            is = new FileInputStream(new File(filePath , fileName));
            
            byte[] buff = new byte[128];
            int len = 0;
            while((len = is.read(buff)) > 0){
                os.write(buff,0,len);
                System.out.print(new String(buff,0,len));
                System.out.print("【读取到的长度："+len+"】");
            }
            
            /*
            byte[] b = new byte[(int)new File(filePath , fileName).length()];
            int count = 0;
            int temp = 0;
            while((temp = is.read())!=(-1)){
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            is.close();
            os.close();
        }
	}
	
	public static void main(String[] args) throws IOException{
		TestFileOutputStream test = new TestFileOutputStream();
		test.getFileFromFile("src/main/resources/", "build.xml");
	}
	
}