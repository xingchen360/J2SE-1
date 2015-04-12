package com.somnus.designPatterns.iterator;
/**
 * 自定义的迭代器接口
 * @author Smile
 *
 */
public interface Iterator {
	/*将游标指向第一个元素*/
	void first();
	/*将游标指向下一个元素*/
	void next();
	/*判断是否存在下一个元素*/
	boolean hasNext();
	boolean isFirst();
	boolean isLast();
	/**/
	Object getCurrentObj();
}
