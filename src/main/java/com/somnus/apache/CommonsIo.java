package com.somnus.apache;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
/**
 * @Title: CommonsIo.java 
 * @Package com.somnus.apache 
 * @Description: TODO
 * @author Somnus
 * @date 2015年5月27日 下午3:06:39 
 * @version V1.0
 */
public class CommonsIo {
    
	public static void main(String[] args) throws Exception {
		
		InputStream is1 = new URL("https://www.baidu.com/").openStream();
		/**
		 * readLines(InputStream input)
		 * readLines(InputStream input, String encoding)
		 * readLines(Reader input)
		 */
		List<String> lines = IOUtils.readLines(is1);
		for(String line:lines){
		    System.out.println(line);
		}
		
		System.out.println("******************************************************************************************");
		InputStream is2 = new URL("https://www.baidu.com/").openStream();
        try {
            /**读取文件
             * toString(InputStream input)
             * toString(InputStream input, String encoding)
             * toString(Reader input)
             * [toString(byte[] input)]
             * [toString(byte[] input, String encoding)]
             */
            System.out.println(IOUtils.toString(is2));
        } finally {
            IOUtils.closeQuietly(is2);
        }
        
        System.out.println("******************************************************************************************");
        File file = new File("src/main/resources/build.xml");
        List<String> lines2 = FileUtils.readLines(file/*, "UTF-8"*/);
        for(String line:lines2){
            System.out.println(line);
        }
        
        System.out.println("******************************************************************************************");
        String result = FileUtils.readFileToString(file/*, "UTF-8"*/);
        System.out.println(result);
        
        System.out.println("******************************************************************************************");
        File srcFile = new File("src/main/resources/build.xml");
        File destFile = new File("target/classes/build.txt");
        /**自动关闭相关流
         * copyFile(File srcFile, File destFile)
         * copyFile(File srcFile, File destFile,boolean preserveFileDate)
         */
        FileUtils.copyFile(srcFile, destFile);
        
        System.out.println("******************************************************************************************");
        InputStream is4 = new URL("https://www.baidu.com/").openStream();
        OutputStream os4 = new FileOutputStream(new File("target/classes/baidu.txt"));
        try {
            /**拷贝流【输入->输出】
             * copy(InputStream input, OutputStream output)
             * copy(InputStream input, Writer output)
             * copy(InputStream input, Writer output, String encoding)
             * copy(Reader input, Writer output)
             * copy(Reader input, OutputStream output)
             * copy(Reader input, OutputStream output, String encoding)
             * copyLarge(Reader input, Writer output)
             * copyLarge(InputStream input, OutputStream output)
             */
            IOUtils.copy(is4, os4);
        } finally{
            IOUtils.closeQuietly(is4);
            IOUtils.closeQuietly(os4);
        }
        System.out.println("******************************************************************************************");
        InputStream is5 = new URL("https://www.baidu.com/").openStream();
        try {
            /**转换为字节数组
             * toByteArray(InputStream input)
             * toByteArray(Reader input)
             * toByteArray(Reader input, String encoding)
             * [toByteArray(String input)]
             */
            byte[] buff5 = IOUtils.toByteArray(is5);
            System.out.println(Hex.encodeHexString(buff5));
        } finally{
            IOUtils.closeQuietly(is5);
        }
        System.out.println("******************************************************************************************");
        InputStream is6 = new URL("https://www.baidu.com/").openStream();
        try {
            /**转换为字符数组
             * toCharArray(InputStream is)
             * toCharArray(InputStream is, String encoding)
             * toCharArray(Reader input)
             */
            char[] buff6 = IOUtils.toCharArray(is6);
            System.out.println(Arrays.toString(buff6));
        } finally{
            IOUtils.closeQuietly(is6);
        }
        System.out.println("******************************************************************************************");
        /**转换为输入流
         * toInputStream(String input)
         * toInputStream(String input, String encoding)
         * toInputStream(CharSequence input)
         * toInputStream(CharSequence input, String encoding)
         */
        InputStream is7 = IOUtils.toInputStream("https://www.baidu.com/");
        byte[] buf = new byte[128];
        int len = 0;
        while((len = is7.read(buf))!=-1){
            System.out.print(new String(buf,0,len));
            System.out.println("[读取到的长度："+len+"]");
        }
        System.out.println("******************************************************************************************");
        OutputStream os7 = new FileOutputStream(new File("target/classes/Somnus.txt"));
        try {
            /**写数据
             * write(byte[] data, OutputStream output)
             * write(byte[] data, Writer output)
             * write(byte[] data, Writer output, String encoding)
             * write(char[] data, Writer output)
             * write(char[] data, OutputStream output)
             * write(char[] data, OutputStream output, String encoding)
             * write(CharSequence data, Writer output)
             * write(CharSequence data, OutputStream output)
             * write(CharSequence data, OutputStream output, String encoding)
             * write(String data, Writer output)
             * write(String data, OutputStream output)
             * write(String data, OutputStream output, String encoding)
             * 
             */
            IOUtils.write("Somnus罂粟花", os7);
        } finally{
            IOUtils.closeQuietly(os7);
        }
        //察看剩余空间
        long freeSpace = FileSystemUtils.freeSpace("C:/");
        System.out.println(freeSpace);
	}
}
