package com.somnus.apache;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

public class CommonsCollections {
	public static void main(String[] args) {

		List<String> list0 = new ArrayList<String>();
		List<String> list1 = new ArrayList<String>();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		List<String> list2 = new ArrayList<String>();
		list2.add("2");
		list2.add("3");
		list2.add("5");
		
		/*集合判断： 
		例1: 判断集合是否为空:*/
		System.out.println(CollectionUtils.isEmpty(list0));
		System.out.println(CollectionUtils.isEmpty(list1));

		/*例2: 判断集合是否不为空:*/
		System.out.println(CollectionUtils.isNotEmpty(list0));
		System.out.println(CollectionUtils.isNotEmpty(list1));

		
		System.out.println(CollectionUtils.union(list1, list2));//并集{3, 2, 1, 5}
		System.out.println(CollectionUtils.intersection(list1, list2));//交集{3, 2}
		System.out.println(CollectionUtils.disjunction(list1, list2));//交集的补集{1, 5}
		System.out.println(CollectionUtils.subtract(list1, list2));//list1与list2的差{1}
	}
}
