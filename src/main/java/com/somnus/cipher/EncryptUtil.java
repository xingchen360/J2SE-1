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
        for (int i = 0; i < arr.length; ++i) {
            final String HEX = "0123456789abcdef"; 
            // 取出这个字节的高4位，然后与0x0f与运算，得到一个0-15之间的数据，通过HEX.charAt(0-15)即为16进制数  
            sb.append(HEX.charAt((arr[i] >> 4) & 0x0f));
            // 取出这个字节的低位，与0x0f与运算，得到一个0-15之间的数据，通过HEX.charAt(0-15)即为16进制数  
            sb.append(HEX.charAt(arr[i] & 0x0f));
        }
        return sb.toString();
    }
    
    /**
     * b[i] & 0xFF运算后得出的仍然是个int,那么为何要和 0xFF进行与运算呢?
     * 直接 Integer.toHexString(b[i]);,将byte强转为int不行吗?
     * 答案是不行的.
     * 
     * 其原因在于:
     * 1.byte的大小为8bits而int的大小为32bits
     * 2.java的二进制采用的是补码形式
     * byte是一个字节保存的，有8个位，即8个0、1。
     * 8位的第一个位是符号位
     * 也就是说0000 0001代表的是数字1 
     *      1000 0000代表的就是-1 
     * 所以正数最大为0111 1111，也就是数字127 
     *    负数最大为1111 1111，也就是数字-128
     *    
     * @see http://blog.csdn.net/zzycgfans/article/details/6782989
     * @return
     */
    @SuppressWarnings("unused")
    private static String byte2hex3(byte[] arr) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            String hex = Integer.toHexString(arr[i] & 0xFF);
            if (hex.length() == 1) {
                sb.append("0");
            }
            sb.append(hex);
        }
        return sb.toString();
    }
}
