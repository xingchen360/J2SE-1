package com.somnus.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestFileReader {

	public static void main(String[] args) {
		FileReader fr=null;
		int c=0;
		try {
			fr=new FileReader("src/main/resources/user.xml");
			while((c=fr.read())!=-1){
				System.out.print((char)c);
			}
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}