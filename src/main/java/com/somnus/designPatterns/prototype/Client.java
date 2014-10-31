package com.somnus.designPatterns.prototype;

import com.somnus.designPatterns.prototype.prototype.ColorManager;
import com.somnus.designPatterns.prototype.prototype.ConcteteColorPrototype;

public class Client {
	public static void main(String[] args) throws CloneNotSupportedException {
		ColorManager colormanager = new ColorManager();
		// 初始化颜色
		colormanager.put("red", new ConcteteColorPrototype(255, 0, 0));
		colormanager.put("green", new ConcteteColorPrototype(0, 255, 0));
		colormanager.put("blue", new ConcteteColorPrototype(0, 0, 255));
		colormanager.put("angry", new ConcteteColorPrototype(255, 54, 0));
		colormanager.put("peace", new ConcteteColorPrototype(128, 211, 128));

		// 使用颜色
		String colorName = "red";
		ConcteteColorPrototype c1 = (ConcteteColorPrototype) colormanager.get(colorName).clonenew();
		c1.Display(colorName);

		colorName = "green";
		ConcteteColorPrototype c2 = (ConcteteColorPrototype) colormanager.get(colorName).clonenew();
		c2.Display(colorName);
	}
}
