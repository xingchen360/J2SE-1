package com.somnus.cipher;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/** 单向加密算法MD5&SHA&MAC
 * @description: TODO 
 * @author Somnus
 * date 2015年4月3日 下午4:17:51  
 */
public class EncryptUtil {
    public static final String KEY_MD5 = "MD5";
    public static final String KEY_SHA = "SHA";
    /** 
     * MAC算法可选以下多种算法 
     *  
     * <pre> 
     * HmacMD5  
     * HmacSHA1  
     * HmacSHA256  
     * HmacSHA384  
     * HmacSHA512 
     * </pre> 
     */  
    public static final String KEY_MAC = "HmacMD5";
  
    /**
     * md5加密  
     * @param str
     * @return
     */
    public static String md5(String str) {  
        return encrypt(str, KEY_MD5);  
    }  
  
    /**
     * sha加密  
     * @param str
     * @return
     */
    public static String sha(String str) {  
        return encrypt(str, KEY_SHA);  
    }  
  
    /** 
     * md5或者sha-1加密 
     *  
     * @param str 
     *            要加密的内容 
     * @param algorithmName 
     *            加密算法名称：md5或者sha-1，不区分大小写 
     * @return 
     */  
    private static String encrypt(String str, String algorithmName) {  
        if (str == null || "".equals(str.trim())) {  
            throw new IllegalArgumentException("请输入要加密的内容");  
        }  
        if (algorithmName == null || "".equals(algorithmName.trim())) {  
            algorithmName = "md5";  
        }  
        String encryptText = null;  
        try {  
            MessageDigest m = MessageDigest.getInstance(algorithmName);  
            m.update(str.getBytes(/*"UTF8"*/));  
            byte s[] = m.digest();  
            return Hex.encodeHexString(s);
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
        return encryptText;  
    }
    
    /** 
     * 初始化HMAC密钥 
     *  
     * @return 
     * @throws Exception 
     */  
    public static String initMacKey(){  
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_MAC);  
            SecretKey secretKey = keyGenerator.generateKey();  
            return Base64.encodeBase64String(secretKey.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;  
    }  
  
    /** 
     * HMAC加密 
     *  
     * @param data 
     * @param key 
     * @return 
     * @throws Exception 
     */  
    public static String encryptHMAC(byte[] data, String key){  
        SecretKey secretKey = new SecretKeySpec(Base64.decodeBase64(key), KEY_MAC); 
        String encryptText = null;
        try {
            Mac mac = Mac.getInstance(secretKey.getAlgorithm());  
            mac.init(secretKey);
            byte s[] = mac.doFinal(data);  
            return Hex.encodeHexString(s);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        return encryptText;
    }
  
    public static void main(String[] args) {  
        //md5加密测试  
        String md5_1 = md5("Somnus");  
        System.out.println(md5_1);  
        System.out.println("md5 length: " + md5_1.length());  
        //sha加密测试  
        String sha_1 = sha("Somnus");  
        System.out.println(sha_1);  
        System.out.println("sha length: " + sha_1.length());
        //HMAC加密 测试
        String key = initMacKey();  
        System.err.println("Mac密钥:" + key);
        
        String hmac = encryptHMAC("Somnus".getBytes(),key);
        System.out.println(hmac);  
        System.out.println("hmac length: " + hmac.length());
    }
}
