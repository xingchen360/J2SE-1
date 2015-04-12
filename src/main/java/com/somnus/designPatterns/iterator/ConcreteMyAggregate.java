package com.somnus.designPatterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMyAggregate {
	private List<Object> list = new ArrayList<Object>();

	public void addObject(Object obj){
		this.list.add(obj);
	}
	public void removeObject(Object obj){
		this.list.remove(obj);
	}
	public List<Object> getList(){
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	public Iterator createIterator(){
		return new ConcreteItreator();
	}
	private class ConcreteItreator implements Iterator{
		/*定义游标用于记录遍历时的位置*/
		private int cursor;
		
		@Override
		public void first() {
			// TODO Auto-generated method stub
			cursor = 0;
		}

		@Override
		public void next() {
			// TODO Auto-generated method stub
			if(cursor<list.size()){
				cursor++;
			}
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(cursor<list.size()){
				return true;
			}else{
				return false;
			}
		}

		@Override
		public boolean isFirst() {
			// TODO Auto-generated method stub
			return cursor ==0?true:false;
		}

		@Override
		public boolean isLast() {
			// TODO Auto-generated method stub
			return cursor ==(list.size()-1)?true:false;
		}

		@Override
		public Object getCurrentObj() {
			// TODO Auto-generated method stub
			return list.get(cursor);
		}
		
	}
	
}
