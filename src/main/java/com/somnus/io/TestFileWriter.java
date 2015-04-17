package com.somnus.io;

import java.io.FileWriter;
import java.io.IOException;

public class TestFileWriter {

	public static void main(String[] args) {
		FileWriter fw=null;
		try {
			fw =new FileWriter("src/main/resources/filewriter.txt");
			fw.write("hello");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		System.out.println("写入正常");
	}
	
}