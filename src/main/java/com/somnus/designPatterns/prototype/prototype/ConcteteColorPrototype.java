package com.somnus.designPatterns.prototype.prototype;

public class ConcteteColorPrototype extends ColorPrototype{
	private int red;
	private int green;
	private int blue;

	public ConcteteColorPrototype(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public ColorPrototype clonenew() throws CloneNotSupportedException  {
		return (ColorPrototype) this.clone();
	}

	public void Display(String colorname) {
		System.out.println(colorname+"'s RGB Values are: "+red+","+green+","+blue);
	}
}
