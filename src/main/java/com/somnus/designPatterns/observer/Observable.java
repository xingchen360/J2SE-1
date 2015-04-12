package com.somnus.designPatterns.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Observable {
	// 用一个List来保存该对象上所有绑定的事件监听器
	List<Observer> Observers = new ArrayList<Observer>();

	// 定义一个方法,用于该主题上注册观察者
	public void registerObserver(Observer o) {
		Observers.add(o);
	}

	// 定义一个方法,用于该主题上删除观察者
	public void removeObserver(Observer o) {
		Observers.remove(o);
	}

	// 通知该主题上注册的所有观察者
	public void notifyObservers(Object value) {
		// 遍历注册到该被观察者上的所有观察者
		for (Iterator<Observer> it = Observers.iterator(); it.hasNext();) {
			Observer o = (Observer) it.next();

			// 显示每个观察者的update方法

			o.update(this, value);
		}
	}
}
