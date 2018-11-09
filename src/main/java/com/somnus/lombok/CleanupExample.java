package com.somnus.lombok;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import lombok.Cleanup;
import lombok.SneakyThrows;

/**
 * @ClassName: CleanupExample
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author pc
 * @date 2018年9月21日
 */
public class CleanupExample {
	
	@SneakyThrows(IOException.class)
	public static void main(String[] args){
		@Cleanup
		InputStream is = new URL("https://www.baidu.com/").openStream();
		System.out.println(IOUtils.toString(is, "UTF-8"));
	}
}
