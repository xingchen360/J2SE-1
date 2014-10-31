package com.somnus.designPatterns.prototype.factory;


public class GreenFactory extends ColorFactory{
	public  Color Create()
    {
        return new GreenColor();
    }
}
