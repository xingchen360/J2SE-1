package com.somnus;

import java.util.LinkedList;

public class Queue<E> {
	private LinkedList<E> list = new LinkedList<E>();
	
	public void push(E e){
		list.add(e);
	}
	
	public E get(){
		return list.removeFirst();
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	public static void main(String[] args) {
		Queue<String> que = new Queue<String>();
		que.push("one");
		que.push("two");
		que.push("three");
		
		System.out.println(que.get());
		System.out.println(que.get());
		System.out.println(que.get());
		
		System.out.println(que.isEmpty());
	}
}
