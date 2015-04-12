package com.somnus.designPatterns.flyweight;

public class Client {

	public static void main(String[] args) {
		Chess chess1 = ChessFactory.getChess("black");
		Chess chess2 = ChessFactory.getChess("black");
		System.out.println(chess1);
		System.out.println(chess2);
		
		System.out.println("增加外部状态的处理");
		chess1.display(new Coordinate(10,10));
		chess1.display(new Coordinate(20,20));
	}

}
