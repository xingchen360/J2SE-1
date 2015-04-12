package com.somnus.designPatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂类
 * @author Smile
 *
 */
public class ChessFactory {
	/*享元池*/
	private static Map<String,Chess> map = new HashMap<String, Chess>();
	public static Chess getChess(String color){
		if(map.get(color)!=null){
			return map.get(color);
		}else{
			Chess chess = new ConcreteChess(color);
			map.put(color, chess);
			return chess;
		}
	}
}
