package com.somnus.io;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestFileReader {

    /**
     * 读取txt文件的内容
     * 
     * @param file
     *            想要读取的文件对象
     * @return 返回文件内容
     */
    public static String txt2String(String fileName) {
        String result = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));// 构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
                result = result + "\n" + s;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 读取txt文件的内容
     * 
     * @param buff
     *            想要读取的文件对象
     * @return 返回文件内容
     */
    public String txt2String(byte[] buff) {
        String result = "";
        try {
            InputStream in = new ByteArrayInputStream(buff, 0, buff.length);// 字节流
            InputStreamReader isr = new InputStreamReader(in);// 字符流
            BufferedReader br = new BufferedReader(isr);// 缓冲流
            String s = null;
            while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
                result = result + "\n" + s;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        String result = txt2String("src/main/resources/user.xml");
        System.out.println(result);
        String[] arr = result.split("\n");
        for(String str:arr){
            System.out.println(str);
        }
        System.out.println(arr.length);
    }

}