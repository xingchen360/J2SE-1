package com.somnus;

import java.util.ArrayList;

public class Aa extends ArrayList<Object>{
	public static void main(String[] args) {
		Aa aa = new Aa();
		aa.add("sss");
		aa.add(1);
		aa.add(3);
		aa.add(null);
		aa.add(4);
		int i = aa.search(null);
		System.out.println(i);
	}
	
	public int search(Object object) {
		int i = size() - 1; // Current index
		int n = 1; // Current distance
		while (i >= 0) {
			Object current = get(i);
			if ((object == null && current == null) || (object != null && object.equals(current))) {
				return n;
			}
			i--;
			n++;
		}
		return -1;
	}
}
