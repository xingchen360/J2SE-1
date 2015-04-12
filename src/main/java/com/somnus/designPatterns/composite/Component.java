package com.somnus.designPatterns.composite;
/**
 * 抽象组件
 * @author Smile
 *
 */
public interface Component {
	void operation();
}
/**
 * 叶子组件
 * @author Smile
 *
 */
interface Leaf extends Component{
	
}
/**
 * 容器组件
 * @author Smile
 *
 */
interface Composite extends  Component{
	
}