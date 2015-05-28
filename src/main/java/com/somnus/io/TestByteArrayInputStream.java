package com.somnus.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestByteArrayInputStream{

	public static void main(String[] args) throws IOException{
	    byte[] buff = "中国abc123".getBytes(/*"UTF-8"*/);
        InputStream is = null;
        try {
            is = new ByteArrayInputStream(buff/*,0,buff.length*/);
            
            /**一次性全部读出来*/
            /*byte[] b = new byte[is.available()];
            int len = is.read(b,0,b.length);
            System.out.println("读入长度为："+len);
            System.out.println(new String(b));*/
            
            int data = 0;
            /*
             * public synchronized int read() {
             *   return (pos < count) ? (buf[pos++] & 0xff) : -1;
             * }
             */
            while ((data = is.read()) != -1){
                System.out.println(data +"|"+(byte)data+"|"
                        +Integer.toBinaryString(data)+"|"+Integer.toHexString(data)+ " ");
            }
            
            /**或者分批读*/
            /*byte[] buff = new byte[128];
            int len = 0;
            while((len = is.read(buff))!=-1){
                System.out.print(new String(buff,0,len));
                System.out.print("[读取到的长度："+len+"]");
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            is.close();
        }
	}
	
}
