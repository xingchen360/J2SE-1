package com.somnus.zip;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.codec.binary.Base64;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;
import org.apache.commons.lang.StringUtils;

public class ZipUtil {

	public static String encodeBase64String(String str) 
	{
		String result = null;
		if (StringUtils.isNotEmpty(str)) 
		{
			try {
				result = Base64.encodeBase64String(compress(str.getBytes("UTF-8")));
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static byte[] compress(byte[] data) 
	{
		byte[] result = null;
		if (data != null && data.length > 0) 
		{
			try 
			{
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				GZIPOutputStream gzip = new GZIPOutputStream(out);
				gzip.write(data);
				gzip.close();
				result = out.toByteArray();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	public static String decodeBase64(String str) 
	{
		String result = null;
		if (StringUtils.isNotEmpty(str)) 
		{
			try {
				result = new String(uncompress(Base64.decodeBase64(str)), "UTF-8");
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static byte[] uncompress(byte[] data) 
	{
		byte[] result = null;
		if (data != null && data.length > 0) 
		{
			try 
			{
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				ByteArrayInputStream in = new ByteArrayInputStream(data);
				GZIPInputStream gzip = new GZIPInputStream(in);
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = gzip.read(buffer)) >= 0) 
				{
					out.write(buffer, 0, len);
				}
				gzip.close();
				result = out.toByteArray();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	   * @desc 将源文件/文件夹生成指定格式的压缩文件,格式zip
	   * @param resourePath 
	   * 						源文件/文件夹
	   * @param targetPath  
	   * 						目的压缩文件保存路径
	   * 						压缩到的位置，如果为null或空字符串则默认解压缩到跟源文件夹或者文件所在的同一目录
	   * @return void
	   * 				
	   * @throws Exception 
	   */
	public static void compressedFile(String resourcesPath,String targetPath) throws Exception{
		File resourcesFile = new File(resourcesPath);     //源文件
		String directoryPath = "";
		//如果为null或空字符串则默认解压缩到跟源文件夹或者文件所在的同一目录
		if (StringUtils.isEmpty(targetPath)) 
			directoryPath = resourcesPath.substring(0,resourcesPath.replaceAll("\\*", "/").lastIndexOf("/"));
		else 
			directoryPath = targetPath;
		File targetFile = new File(directoryPath);           //目的
		//如果目的路径不存在，则新建
		if(!targetFile.exists())
		{     
			targetFile.mkdirs();  
		}
		String targetName = resourcesFile.getName()+".zip";   //目的压缩文件名
		FileOutputStream outputStream = new FileOutputStream(directoryPath+File.separator+targetName);
		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(outputStream));
		createCompressedFile(out, resourcesFile, "");
		out.close();  
	}
	 /**
	  * @desc 生成压缩文件。 如果是文件夹，则使用递归，进行文件遍历、压缩
	  *       				如果是文件，直接压缩
	  * @param out  
	  * 					输出流
	  * @param file  
	  * 					目标文件
	  * @return void
	  * @throws Exception 
	  */
	public static void createCompressedFile(ZipOutputStream out,File file,String dir) throws Exception{
		//如果当前的是文件夹，则进行进一步处理
		if(file.isDirectory()){
			//得到文件列表信息
			File[] files = file.listFiles();
			//将文件夹添加到下一级打包目录
			out.putNextEntry(new ZipEntry(dir+"/"));
			dir = dir.length() == 0 ? "" : dir +"/";
			//循环将文件夹中的文件打包
			for(int i = 0 ; i < files.length ; i++)
			{
				createCompressedFile(out, files[i], dir + files[i].getName());         //递归处理
			}
		}
		else
		{   //当前的是文件，打包处理
			//文件输入流
			InputStream is = new FileInputStream(file);
			out.putNextEntry(new ZipEntry(dir));
			//进行写操作
			int len =  0;
			byte[] buffer = new byte[1024];
			while((len = is.read(buffer)) > 0)
			{
				out.write(buffer,0,len);
			}
			//关闭输入流
			is.close();
		}
	}
	
	/**
	 * 解压缩zip包
	 * 
	 * @param zipFilePath
	 *            zip文件路径
	 * @param targetPath
	 *            解压缩到的位置，如果为null或空字符串则默认解压缩到跟zip包同目录跟zip包同名的文件夹下
	 * @throws IOException
	 */
	public static void decompressionFile(String zipFilePath, String targetPath)throws IOException {
		ZipFile zipFile = new ZipFile(zipFilePath);
		String directoryPath = "";
		//如果为null或空字符串则默认解压缩到跟zip包同目录跟zip包同名的文件夹下
		if (StringUtils.isEmpty(targetPath)) 
			directoryPath = zipFilePath.substring(0,zipFilePath.lastIndexOf("."));
		else 
			directoryPath = targetPath;
		
		Enumeration<ZipEntry> entryEnum = zipFile.getEntries();
		if (entryEnum != null) 
		{
			ZipEntry zipEntry = null;
			while (entryEnum.hasMoreElements()) 
			{
				zipEntry = (ZipEntry) entryEnum.nextElement();
				//如果为目录
				if (zipEntry.isDirectory()) 
				{
					System.out.println("文件夹路劲--------------"+directoryPath + File.separator+ zipEntry.getName());
					File target = new File(directoryPath + File.separator+ zipEntry.getName());
					target.mkdirs();
					continue;
				}
				if (zipEntry.getSize() !=-1) 
				{
					// 文件
					File targetFile = new File(directoryPath+ File.separator + zipEntry.getName());
					//如果目的文件夹的父目录为空，则创建
					if (!targetFile.getParentFile().exists()) {
						targetFile.getParentFile().mkdirs();
						targetFile = new File(targetFile.getAbsolutePath());
					}
					OutputStream os = new BufferedOutputStream(new FileOutputStream(targetFile));
					InputStream is = zipFile.getInputStream(zipEntry);
					byte[] buffer = new byte[1024];
					int len = 0;
					while ((len = is.read(buffer, 0, 1024)) >= 0) 
					{
						os.write(buffer, 0, len);
					}
					os.close();
					is.close();
				} 
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(ZipUtil.encodeBase64String("abcdefg"));
		System.out.println(ZipUtil.decodeBase64("H4sIAAAAAAAAAEtMSk5JTUsHAKZqKjEHAAAA"));
		
		try {
			System.out.println(Base64.encodeBase64String("abcdefg".getBytes("UTF-8")));
			System.out.println(new String(Base64.decodeBase64("YWJjZGVmZw=="),"UTF-8"));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ZipUtil.compressedFile("d:/software/demo", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
