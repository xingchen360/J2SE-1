package com.somnus.io;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestByteArrayInputStream{

	public static void main(String[] args) throws IOException{
	    byte[] buff = "中国abc123".getBytes(/*"UTF-8"*/);
        InputStream is = null;
        try {
            is = new ByteArrayInputStream(buff);
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
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            is.close();
        }
	}
	
}
