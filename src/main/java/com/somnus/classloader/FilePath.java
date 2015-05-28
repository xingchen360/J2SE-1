package com.somnus.classloader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/** 
 * @description: 获取文件在服务器（本地编译好的项目）中的路劲 
 * @author Somnus
 * date 2015年4月1日 下午5:56:46  
 */
public class FilePath {
    public void print() throws IOException{
        String url = getClass().getClassLoader().getResource("logback.xml").getPath();
        System.out.println(url);
        InputStream is = getClass().getClassLoader().getResourceAsStream("user.xml");
        try {
            byte[] buf = new byte[128];
            int len = 0;
            while((len = is.read(buf))!=-1){
                System.out.println(Arrays.toString(buf));
                System.out.print(new String(buf,0,len));
                System.out.print("[读取到的长度："+len+"]");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            is.close();
        }
    }
    public static void main(String[] args) throws IOException {
        FilePath demo = new FilePath();
        demo.print();
    }
}
