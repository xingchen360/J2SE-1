package com.somnus.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class TestBufferedOutputStream {
	
	public static void main(String[] args) throws Exception {
		OutputStream os = null;
        BufferedOutputStream bos = null;
        try {
            os = new FileOutputStream("target/classes/test.txt");
            bos = new BufferedOutputStream(os);
            bos.write("http://google.com/".getBytes(/*"UTF-8"*/));
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            bos.close();
            os.close();
        }
	}
	
}