package com.somnus.io;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ByteArrayInputStreamTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			byte[] buff = new byte[] { 0, 1, 2,127,-1,-2, -128,'0','1','2','3','a','b','A','B'};

			InputStream in = new ByteArrayInputStream(buff, 0, buff.length);
			int data = 0;
			while ((data=  in.read()) != -1)
			{
				System.out.println(data + " ");
			}
			in.close();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
