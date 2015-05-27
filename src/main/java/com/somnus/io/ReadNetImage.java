package com.somnus.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadNetImage {
	public byte[] getImageUrl(String imageUrl) throws IOException {
		byte[] fileData = null;
		InputStream is = null;
        ByteArrayOutputStream bos = null;
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.connect();
            is = httpConn.getInputStream();
            bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[128];
            int len = 0;
            while ((len = is.read(buffer, 0, buffer.length)) != -1) {
                bos.write(buffer, 0, len);
            }
            fileData = bos.toByteArray();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            is.close();
            bos.close();
        }
		return fileData;
	}
}