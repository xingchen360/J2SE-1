package com.somnus;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UniqueList<T> {
	/**
	 * List 去掉重复的值，并保持原先List顺序
	 * @param list
	 * @return
	 */
	private  List<T> removeDuplicate(List<T> list) {
		Set<T> set = new HashSet<T>();
		List<T> newList = new ArrayList<T>();
		for (Iterator<T> iter = list.iterator(); iter.hasNext();) {
			T element = (T) iter.next();
			if (set.add(element))
				newList.add(element);
		}
		return newList;
	}

	public static void main(String[] args) {
		UniqueList<String> uniqueList = new UniqueList<String>();
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("3");
		list.add("3");
		list.add("5");
		list.add("7");
		List<String> newlist = uniqueList.removeDuplicate(list);
		for(String data:newlist){
			System.out.println(data);
		}
	}
}
