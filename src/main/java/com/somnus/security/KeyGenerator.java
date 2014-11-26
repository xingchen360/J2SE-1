package com.somnus.security;

import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Scanner;

public class KeyGenerator {

	private static String algorithm = null;
	private static int signatureLen = 0;
	
	public static void main(String[] args) {

		Scanner stdbin = new Scanner(System.in);
		String input = null;
		while (true) {
			if (algorithm == null) {
				System.out.println("请输入数字1或2，选择相应的密钥对的生成算法：\n1-->RSA    2-->DSA");
				input = stdbin.next().trim();
				if (input.equals("1"))
					algorithm = "RSA";
				else if (input.equals("2"))
					algorithm = "DSA";
				else {
					System.out.println("输入错误，请重新输入");
					continue;
				}
			}

			if (signatureLen == 0) {
				System.out.println("请输入数字1或2，选择相应的数字签名的长度\n1-->64位    2-->128位");
				input = stdbin.next().trim();
				if (input.equals("1"))
					signatureLen = 512;
				else if (input.equals("2"))
					signatureLen = 1024;
				else {
					System.out.println("输入错误，请重新输入");
					continue;
				}
			}

			KeyPairGenerator pairGen;
			try {
				pairGen = KeyPairGenerator.getInstance(algorithm);
				SecureRandom srand = new SecureRandom("ABCDEFGHIJK".getBytes());
				pairGen.initialize(signatureLen, srand);
				KeyPair keyPair = pairGen.generateKeyPair();

				if (algorithm.equals("RSA"))
					generateRSAKey(keyPair);
				else
					generateDSAKey(keyPair);
				
				break;
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (Exception e) {	
				e.printStackTrace();
			}			
		}
	}
	
	private static void generateDSAKey(KeyPair keyPair) throws Exception
	{
		DSAPublicKey publicKey = (DSAPublicKey)keyPair.getPublic();
		DSAPrivateKey privateKey = (DSAPrivateKey)keyPair.getPrivate();
		
		FileOutputStream foutPub = new FileOutputStream("src\\main\\resources\\public.cer");
		foutPub.write(publicKey.getEncoded());
		foutPub.close();
		System.out.println("生成公钥完毕");
		
		FileOutputStream fout = new FileOutputStream("src\\main\\resources\\private.key");
		fout.write(privateKey.getEncoded());
		fout.close();
		System.out.println("生成私钥完毕");
	}

	private static void generateRSAKey(KeyPair keyPair) throws Exception
	{
		RSAPublicKey publicKey = (RSAPublicKey)keyPair.getPublic();
		RSAPrivateKey privateKey = (RSAPrivateKey)keyPair.getPrivate();
		
		FileOutputStream foutPub = new FileOutputStream("src\\main\\resources\\public.cer");
		foutPub.write(publicKey.getEncoded());
		foutPub.close();
		System.out.println("生成公钥完毕");
		
		FileOutputStream fout = new FileOutputStream("src\\main\\resources\\private.key");
		fout.write(privateKey.getEncoded());
		fout.close();
		System.out.println("生成私钥完毕");
	}
}
