package com.somnus.designPatterns.facade;

public class Client {

	public static void main(String[] args) {
		EncryptFacade ef = new EncryptFacade();  
        ef.fileEncrypt("com/somnus/designPatterns/facade/src.txt", 
        		"target/classes/des.txt");  
	}

}
