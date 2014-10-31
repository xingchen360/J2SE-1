package com.somnus.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader
{
	private String name;
	private String path = "E:\\";
	private final String fileType = ".class";
	
	public MyClassLoader(String name)
	{
		super();
		this.name = name;
	}
	public MyClassLoader(ClassLoader parent,String name)
	{
		super(parent);
		this.name = name;
	}
	public String toString()
	{
		return this.name;
	}
	public String getPath()
	{
		return path;
	}
	public void setPath(String path)
	{
		this.path = path;
	}
	public Class<?> findClass(String name) throws ClassNotFoundException
	{
		byte[] data = this.loadClassData(name);
		
		return this.defineClass(name, data, 0, data.length);
	}
	private byte[] loadClassData(String name)
	{
		InputStream is = null;
		byte[] data = null;
		ByteArrayOutputStream baos = null;
		try
		{
			this.name = this.name.replace(".", "\\");
			is = new FileInputStream(new File(path+name+fileType));
			baos = new ByteArrayOutputStream();
			int ch = 0;
			while(-1 != (ch = is.read()))
			{
				baos.write(ch);
			}
			data = baos.toByteArray();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				is.close();
				baos.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return data;
	}
	public static void main(String[] args) throws Exception
	{
		MyClassLoader loader1 = new MyClassLoader("loader1");
		loader1.setPath("e:\\myapp\\serverlib\\");
		
		MyClassLoader loader2 = new MyClassLoader(loader1,"loader2");
		loader2.setPath("e:\\myapp\\clientlib\\");
		
		MyClassLoader loader3 = new MyClassLoader(null,"loader3");
		loader3.setPath("e:\\myapp\\otherlib\\");
		
		test(loader2);
		test(loader3);
	}
	public static void test(ClassLoader loader) throws Exception
	{
		Class clazz = loader.loadClass("com.classloader.Sample");
		Object object = clazz.newInstance();
	}
}
