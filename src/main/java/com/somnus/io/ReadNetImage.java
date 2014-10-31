package com.somnus.io;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ReadNetImage
{
	public byte[] getImageUrl(String imageUrl)
	{
		byte[] fileData = null;
		try
		{
			URL url = new URL(imageUrl);  
			
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();  
			
			httpConn.connect();  
			
			InputStream is = httpConn.getInputStream();  
			
			ByteArrayOutputStream bos = new ByteArrayOutputStream();  
			
			byte[] buffer = new byte[400];  
			
			int len = 0;  
			
			while ((len = is.read(buffer,0,400)) != -1) 
			{  
			    bos.write(buffer, 0, len);  
			}  
			
			fileData = bos.toByteArray();  
			
			is.close(); 
			bos.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
        return fileData;
	}
}