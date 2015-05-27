package com.somnus.io;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class TestByteArrayOutputStream {

	public static void main(String[] args) throws IOException{
		ByteArrayOutputStream bos = null;
        //A
        OutputStream os = null;
        //C包装一个管道缓冲区
        BufferedOutputStream buffos = null;
        try {
            bos = new ByteArrayOutputStream();
            //知道byte数组，往ByteArrayOutputStream组织数据
            byte[] buffer = "中国abc123".getBytes("UTF-8");
            /*
             * ByteArrayOutputStream输出流的write方法只是把byte数组组织进去
             * 不会往硬盘执行写
             */
            bos.write(buffer);
            //可以把ByteArrayOutputStream输出流变成byte数组
            byte[] result = bos.toByteArray();
            System.out.println(Arrays.toString(result));
            os = new FileOutputStream(new File("target/classes/test.txt"));
            bos.writeTo(os);
            //B
            os.write(result);//知道byte数组数据      往硬盘写入数据 没必要再转一次
            buffos = new BufferedOutputStream(os);
            buffos.write(result);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            bos.close();
            os.close();
            buffos.close();
        }
	}

	/**
	 * 根据指定目录文件
	 * 获得指定文件的byte数组
	 * @throws IOException 
	 */
	public byte[] getBytesFromFile(String filePath, String fileName) throws IOException{
		byte[] buffer = null;
		ByteArrayOutputStream bos = null;
        InputStream is = null;
        try {
            bos = new ByteArrayOutputStream();
            is = new FileInputStream(new File(filePath , fileName));
            byte[] buff = new byte[128];
            int len = 0;;
            /*
             * 读取FileInputStream的输入流到ByteArrayOutputStream中
             * 是为了得到byte数组
             */
            while ((len = is.read(buff)) != -1) {
                bos.write(buff, 0, len);
            }
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            is.close();
            bos.close();
        }
		return buffer;
	}
}