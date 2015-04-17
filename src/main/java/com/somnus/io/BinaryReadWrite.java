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

	public BinaryReadWrite() {
		init();
	}

	private void init() {
		try {
			if (!new File(s_FilePath).exists()) {
				new File(s_FilePath).createNewFile();
			}
			dos = new DataOutputStream(new FileOutputStream(
					new File(s_FilePath)));
			dis = new DataInputStream(new FileInputStream(new File(s_FilePath)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeBinaryStream() throws IOException {
		if (dos != null) {
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

			dos.writeInt(buff.length);
			dos.write(buff);

			dos.write("中".getBytes(/*"UTF-8"*/));

			dos.write("国".getBytes("GB2312"));
			
			dos.writeBytes("abcd1234");

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

				int len = dis.readInt();
				byte[] buffer = new byte[len];
				dis.read(buffer, 0, buffer.length);
				System.out.println(new String(buffer));

				byte[] buffer2 = new byte[3];
				dis.read(buffer2, 0, buffer2.length);
				System.out.println(new String(buffer2/*, "UTF-8"*/));

				byte[] buffer3 = new byte[2];
				dis.read(buffer3, 0, buffer3.length);
				System.out.println(new String(buffer3, "GB2312"));
				
				byte[] buffer4 = new byte[8];
				dis.read(buffer4, 0, buffer4.length);
				for(byte b:buffer4){
					System.out.println("#"+b);
				}
				System.out.println(new String(buffer4));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BinaryReadWrite bin = new BinaryReadWrite();
		bin.writeBinaryStream();
		bin.readBinaryStream();
		
		String str = "abcd<好好学习";
		System.out.println(str.length());
		System.out.println(str.getBytes(/*"UTF-8"*/).length);
		System.out.println(str.getBytes("GB2312").length);
	}
}