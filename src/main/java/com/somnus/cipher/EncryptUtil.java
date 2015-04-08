package com.somnus.cipher;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/** 
 * @description: TODO 
 * @author Somnus
 * date 2015年4月3日 下午4:17:51  
 */
public class EncryptUtil {
    public static void main(String[] args) {  
        //md5加密测试  
        String md5_1 = md5("Somnus");  
        System.out.println(md5_1);  
        System.out.println("md5 length: " + md5_1.length());  
        //sha加密测试  
        String sha_1 = sha("Somnus");  
        System.out.println(sha_1);  
        System.out.println("sha length: " + sha_1.length());  
    }  
  
    /**
     * md5加密  
     * @param str
     * @return
     */
    public static String md5(String str) {  
        return encrypt(str, "md5");  
    }  
  
    /**
     * sha加密  
     * @param str
     * @return
     */
    public static String sha(String str) {  
        return encrypt(str, "sha-1");  
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
            m.update(str.getBytes("UTF8"));  
            byte s[] = m.digest();  
            return byte2hex(s);  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();
        }  
        return encryptText;  
    }  
  
    // 从字节数组到十六进制字符串转换 
    private static String byte2hex(byte[] arr) {  
        StringBuffer sb = new StringBuffer();  
        for (int i = 0; i < arr.length; ++i) {
            sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1,3));  
        }  
        return sb.toString();  
    }
    
    // 从字节数组到十六进制字符串转换 
    @SuppressWarnings("unused")
    private static String byte2hex2(byte[] arr) {  
        StringBuffer sb = new StringBuffer();  
        for (int i = 0; i < arr.length; ++i) 
        {
            final String HEX = "0123456789abcdef"; 
            // 取出这个字节的高4位，然后与0x0f与运算，得到一个0-15之间的数据，通过HEX.charAt(0-15)即为16进制数  
            sb.append(HEX.charAt((arr[i] >> 4) & 0x0f));  
            // 取出这个字节的低位，与0x0f与运算，得到一个0-15之间的数据，通过HEX.charAt(0-15)即为16进制数  
            sb.append(HEX.charAt(arr[i] & 0x0f));  
        }  
        return sb.toString();  
    }  
}
