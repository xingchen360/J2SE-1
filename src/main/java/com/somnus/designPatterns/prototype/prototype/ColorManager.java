package com.somnus.designPatterns.prototype.prototype;

import java.util.HashMap;

public class ColorManager {
	 private HashMap<String,ColorPrototype> colors = new HashMap<String,ColorPrototype>();
	 public void put(String key,ColorPrototype cp)
	 {
		 colors.put(key, cp);
	 }
	 public ColorPrototype get(String key)
	 {
		 return  colors.get(key);
	 }
}
