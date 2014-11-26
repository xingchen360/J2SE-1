package com.somnus.security;

import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


public class DigitSignature {

	private String keyAlgorithm = "";
	private String signAlgorithm = "";
	private int signLength ;
	private String keyLoc = "";

	public boolean validate(byte[] data) throws Exception {
		try {
			int begin= data.length - signLength;
			byte[] signArr= new byte[signLength];
			byte[] msgArr= new byte[begin];
			System.arraycopy(data, begin, signArr, 0, signLength);
			System.arraycopy(data, 0, msgArr, 0, begin);
			
			PublicKey publicKey = GeneratePublicKey();
			Signature sig = Signature.getInstance(signAlgorithm);
			sig.initVerify(publicKey);
			sig.update(msgArr);
			return sig.verify(signArr);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


	public byte[] genValiInfo(byte[] data) {
		try {
			PrivateKey privateKey = GeneratePrivateKey();
			Signature sig = Signature.getInstance(signAlgorithm);
			sig.initSign(privateKey);
			sig.update(data);
			return sig.sign();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	private PublicKey GeneratePublicKey() throws Exception {
		FileInputStream fin;
		try {
			fin = new FileInputStream(keyLoc + "public.cer");
			byte[] encodedpubkey = new byte[fin.available()];
			fin.read(encodedpubkey);
			fin.close();
			X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(encodedpubkey);
			KeyFactory keyFactory = KeyFactory.getInstance(keyAlgorithm);
			PublicKey pubKey = keyFactory.generatePublic(pubKeySpec);
			return pubKey;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	private PrivateKey GeneratePrivateKey() throws Exception {
		FileInputStream fin;
		try {
			fin = new FileInputStream(keyLoc + "private.key");
			byte[] encodedprikey = new byte[fin.available()];
			fin.read(encodedprikey);
			fin.close();
			PKCS8EncodedKeySpec priKeySpec = new PKCS8EncodedKeySpec(encodedprikey);
			KeyFactory keyFactory = KeyFactory.getInstance(keyAlgorithm);
			PrivateKey priKey = keyFactory.generatePrivate(priKeySpec);
			return priKey;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public String getKeyAlgorithm() {
		return keyAlgorithm;
	}

	public void setKeyAlgorithm(String keyAlgorithm) {
		this.keyAlgorithm = keyAlgorithm;
	}

	public String getSignAlgorithm() {
		return signAlgorithm;
	}

	public void setSignAlgorithm(String signAlgorithm) {
		this.signAlgorithm = signAlgorithm;
	}

	public int getSignLength() {
		return signLength;
	}

	public void setSignLength(int signLength) {
		this.signLength = signLength;
	}

	public String getKeyLoc() {
		return keyLoc;
	}

	public void setKeyLoc(String keyLoc) {
		this.keyLoc = keyLoc;
	}

	public static void main(String[] args) throws Exception {
		DigitSignature dig = new DigitSignature();
		dig.setKeyAlgorithm("RSA");
		dig.setSignAlgorithm("SHA1withRSA");
		dig.setSignLength(64);
		dig.setKeyLoc("src\\main\\resources\\");
		
		byte[] sendArr = "helloworld".getBytes("GBK");
		byte[] signArr = dig.genValiInfo(sendArr);
		
		//组装数据【发送数据+数字签名】
		byte[] receiveArr = new byte[sendArr.length+signArr.length];
		System.arraycopy(sendArr, 0, receiveArr, 0, sendArr.length);
		System.arraycopy(signArr, 0, receiveArr, sendArr.length, signArr.length);
		
		boolean flag = dig.validate(receiveArr);
		System.out.println(flag);
		
	}
}