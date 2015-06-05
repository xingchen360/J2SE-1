package com.somnus.cipher;

import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @Title: RsaEncrypt.java 
 * @Package com.ips.bmps.module.report.bankconnect.util 
 * @Description: TODO
 * @author Somnus
 * @date 2015年6月5日 下午2:02:44 
 * @version V1.0 
 */
public class RsaUtil {
    private static final Logger LOG = LoggerFactory.getLogger(RsaUtil.class);
    public static final String ALGORITHM = "RSA";  
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";  
  
    private static final String PUBLIC_KEY = "RSAPublicKey";  
    private static final String PRIVATE_KEY = "RSAPrivateKey";  
    
    private static final String PUBLIC_KEY_PATH = "public.cer";
    private static final String PRIVATE_KEY_PATH = "private.key";
    
    private static Map<String, Object> keymap;
    static{
        RsaUtil rutil = new RsaUtil();
        keymap = rutil.initKey();
    }
    /** 
     * 用私钥对信息生成数字签名 
     *  
     * @param data 
     *            加密数据 
     * @param privateKey 
     *            私钥 
     * @return 
     * @throws Exception 
     */  
    public static String sign(byte[] data) throws Exception { 
        
        // 解密由base64编码的私钥  
        byte[] keyBytes = Base64.decodeBase64(getPrivateKey());
        // 构造PKCS8EncodedKeySpec对象  
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);  
        // ALGORITHM 指定的加密算法  
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);  
        // 取私钥匙对象  
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);  
        // 用私钥对信息生成数字签名  
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);  
        signature.initSign(priKey);  
        signature.update(data);  
        return Base64.encodeBase64String(signature.sign());
    }  
  
    /** 
     * 校验数字签名 
     *  
     * @param data 
     *            加密数据 
     * @param publicKey 
     *            公钥 
     * @param sign 
     *            数字签名 
     *  
     * @return 校验成功返回true 失败返回false 
     * @throws Exception 
     *  
     */  
    public static boolean verify(byte[] data,String sign)throws Exception {  
        // 解密由base64编码的公钥  
        byte[] keyBytes = Base64.decodeBase64(getPublicKey());
        // 构造X509EncodedKeySpec对象  
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);  
        // ALGORITHM 指定的加密算法  
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);  
        // 取公钥匙对象  
        PublicKey pubKey = keyFactory.generatePublic(keySpec);  
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);  
        signature.initVerify(pubKey);  
        signature.update(data);  
        // 验证签名是否正常  
        return signature.verify(Base64.decodeBase64(sign));  
    }  
  
    /** 
     * 解密<br> 
     * 用私钥解密 
     *  
     * @param data 
     * @param key 
     * @return 
     * @throws Exception 
     */  
    public static byte[] decryptByPrivateKey(byte[] data)throws Exception {  
        // 对密钥解密  
        byte[] keyBytes = Base64.decodeBase64(getPrivateKey());
        // 取得私钥  
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);  
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);  
        // 对数据解密  
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());  
        cipher.init(Cipher.DECRYPT_MODE, privateKey);  
        return cipher.doFinal(data);  
    }  
  
    /** 
     * 解密<br> 
     * 用公钥解密 
     *  
     * @param data 
     * @param key 
     * @return 
     * @throws Exception 
     */  
    public static byte[] decryptByPublicKey(byte[] data)throws Exception {  
        // 对密钥解密  
        byte[] keyBytes = Base64.decodeBase64(getPublicKey()); 
        // 取得公钥  
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);  
        Key publicKey = keyFactory.generatePublic(x509KeySpec);  
        // 对数据解密  
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());  
        cipher.init(Cipher.DECRYPT_MODE, publicKey);  
        return cipher.doFinal(data);  
    }  
  
    /** 
     * 加密<br> 
     * 用公钥加密 
     *  
     * @param data 
     * @param key 
     * @return 
     * @throws Exception 
     */  
    public static byte[] encryptByPublicKey(byte[] data)throws Exception {  
        // 对公钥解密  
        byte[] keyBytes = Base64.decodeBase64(getPublicKey());
        // 取得公钥  
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);  
        Key publicKey = keyFactory.generatePublic(x509KeySpec);  
        // 对数据加密  
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());  
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);  
        return cipher.doFinal(data);  
    }  
  
    /** 
     * 加密<br> 
     * 用私钥加密 
     *  
     * @param data 
     * @param key 
     * @return 
     * @throws Exception 
     */  
    public static byte[] encryptByPrivateKey(byte[] data) throws Exception {  
        // 对密钥解密  
        byte[] keyBytes = Base64.decodeBase64(getPrivateKey()); 
        // 取得私钥  
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);  
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);  
        // 对数据加密  
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());  
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);  
        return cipher.doFinal(data);  
    }  
  
    /** 
     * 取得私钥 
     *  
     * @param keyMap 
     * @return 
     * @throws Exception 
     */  
    public static String getPrivateKey()throws Exception{  
        Key key = (Key) keymap.get(PRIVATE_KEY); 
        LOG.info("私钥:{}",Base64.encodeBase64String(key.getEncoded()));
        return Base64.encodeBase64String(key.getEncoded());
    }  
  
    /** 
     * 取得公钥 
     *  
     * @param keyMap 
     * @return 
     * @throws Exception 
     */  
    public static String getPublicKey()throws Exception {  
        Key key = (Key) keymap.get(PUBLIC_KEY);
        LOG.info("公钥:{}",Base64.encodeBase64String(key.getEncoded()));
        return Base64.encodeBase64String(key.getEncoded());
    }  
  
    /** 
     * 初始化密钥 
     *  
     * @return 
     * @throws Exception 
     */  
    public Map<String, Object> initKey(){
        InputStream in1 = getClass().getClassLoader().getResourceAsStream(PUBLIC_KEY_PATH);
        InputStream in2 = getClass().getClassLoader().getResourceAsStream(PRIVATE_KEY_PATH);
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
            /*生成公钥*/
            byte[] encodedpubkey = new byte[in1.available()];
            in1.read(encodedpubkey);
            X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(encodedpubkey);
            PublicKey publicKey = keyFactory.generatePublic(pubKeySpec);
            /*生成私钥*/
            byte[] encodedprikey = new byte[in2.available()];
            in2.read(encodedprikey);
            PKCS8EncodedKeySpec priKeySpec = new PKCS8EncodedKeySpec(encodedprikey);
            PrivateKey privateKey = keyFactory.generatePrivate(priKeySpec);
            /*封装进map*/
            Map<String, Object> keyMap = new HashMap<String, Object>();
            keyMap.put(PUBLIC_KEY, publicKey);
            keyMap.put(PRIVATE_KEY, privateKey); 
            return keyMap;
        } catch(Exception e){
            LOG.error(e.getMessage(), e);
            throw new RuntimeException();
        }
        finally {
            try {
                in2.close();
                in2.close();
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
            }
        }
    }
    /** 
     * 初始化密钥 2
     * @return 
     * @throws Exception 
     */  
    public static Map<String, Object> initKey2() throws Exception {  
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(ALGORITHM);  
        keyPairGen.initialize(1024);  
        KeyPair keyPair = keyPairGen.generateKeyPair();  
        // 公钥  
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  
        // 私钥  
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();  
        Map<String, Object> keyMap = new HashMap<String, Object>(2);  
        keyMap.put(PUBLIC_KEY, publicKey);  
        keyMap.put(PRIVATE_KEY, privateKey);  
        return keyMap;  
    }  
    
    public static void main(String[] args) throws Exception {
        System.out.println("公钥加密————————————————————私钥解密");  
        String inputStr = "abc";  
        byte[] data = "abc".getBytes();  
        byte[] encodedData = RsaUtil.encryptByPublicKey(data);  
        byte[] decodedData = RsaUtil.decryptByPrivateKey(encodedData);  
        String outputStr = new String(decodedData);  
        System.out.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);
        
        
        System.out.println("私钥加密————————————————————公钥解密");  
        String inputStr2 = "sign";  
        byte[] data2 = inputStr2.getBytes();  
        byte[] encodedData2 = RsaUtil.encryptByPrivateKey(data2);  
        byte[] decodedData2 = RsaUtil.decryptByPublicKey(encodedData2);  
        String outputStr2 = new String(decodedData2);  
        System.out.println("加密前: " + inputStr2 + "\n\r" + "解密后: " + outputStr2);  
        System.out.println("私钥签名——公钥验证签名");  
        // 产生签名  
        String sign = RsaUtil.sign(encodedData2);  
        System.out.println("签名:\r" + sign);  
        // 验证签名  
        boolean status = RsaUtil.verify(encodedData2,sign);  
        System.out.println("状态:\r" + status);  
    }
}
