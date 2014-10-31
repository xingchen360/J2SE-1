package com.somnus.designPatterns.prototype.factory;


public class RedFactory extends ColorFactory{
	public  Color Create()
    {
        return new RedColor();
    }
}
