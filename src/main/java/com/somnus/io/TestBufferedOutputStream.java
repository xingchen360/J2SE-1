package com.somnus.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class TestBufferedOutputStream
{
	public static void main(String[] args) throws Exception
	{
		OutputStream os = new FileOutputStream("config/test.txt");
		
		BufferedOutputStream  bos = new BufferedOutputStream(os);
		
		bos.write("http://google.com/".getBytes());
		
		bos.close();
		os.close();
	}
}