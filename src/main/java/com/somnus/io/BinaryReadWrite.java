package com.somnus.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryReadWrite {
	private DataInputStream dis = null;
	private DataOutputStream dos = null;
	private String s_FilePath = "src/main/resources/bin.dat";
	private byte[] buff = "{\"name\":\"alen\"}".getBytes();

	public BinaryReadWrite() 
	{
		init();
	}

	private void init() 
	{
		try 
		{
			if (!new File(s_FilePath).exists()) 
			{
				new File(s_FilePath).createNewFile();
			}
			dos = new DataOutputStream(new FileOutputStream(new File(s_FilePath)));
			dis = new DataInputStream(new FileInputStream(new File(s_FilePath)));
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public void writeBinaryStream() throws IOException 
	{
		if (dos != null) 
		{
			dos.writeBoolean(true);
			
			char c = 'a';
			dos.writeChar((int) c);
			
			Double d = 12.567d;
			dos.writeDouble(d);
			
			Float f = 56.782f;
			dos.writeFloat(f);
			
			int k = 105;
			dos.writeInt(k);
			
			long l = 98765l;
			dos.writeLong(l);
			
			short st = 12;
			dos.writeShort(st);
			
			String cs = "Java读写二进制文件";
			dos.writeUTF(cs);
			dos.writeInt(buff.length);
			dos.write(buff, 0, buff.length);
			
			dos.flush();
			dos.close();
		}
	}

	public void readBinaryStream() throws IOException {
		if (dis != null) {
			while (dis.available() > 0) {
				System.out.println(dis.available());
				System.out.println(dis.readBoolean());
				System.out.println((char) dis.readChar());
				System.out.println(dis.readDouble());
				System.out.println(dis.readFloat());
				System.out.println(dis.readInt());
				System.out.println(dis.readLong());
				System.out.println(dis.readShort());
				System.out.println(dis.readUTF());
				int len = dis.readInt();
				byte[] buffer = new byte[len];
				dis.read(buffer, 0, buffer.length);
				String data = new String(buffer,"UTF-8");
				System.out.println(data);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BinaryReadWrite bin = new BinaryReadWrite();
		bin.writeBinaryStream();
		bin.readBinaryStream();
	}
}