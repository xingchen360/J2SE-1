package com.somnus.io;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class TestByteArrayInputStream{

	public static void main(String[] args){
		try{
			byte[] buff = "中国abc123".getBytes(/*"UTF-8"*/);

			InputStream in = new ByteArrayInputStream(buff, 0, buff.length);
			int data = 0;
			/*
			 * public synchronized int read() {
             *   return (pos < count) ? (buf[pos++] & 0xff) : -1;
             * }
			 */
			while ((data = in.read()) != -1){
				System.out.println(data +"|"+(byte)data+"|"
				        +Integer.toBinaryString(data)+"|"+Integer.toHexString(data)+ " ");
			}
			in.close();

		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
}
