package com.somnus.async2;

public class Cake {
	
	private String buffer;
	
	public Cake(int count, char c) {
		super();
		char[] buffer = new char[count];
		for (int i = 0; i < count; i++) {
			buffer[i] = c;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.buffer = new String(buffer);
	}
	
	@Override
	public String toString() {
		return buffer;
	}
}
