package com.somnus.designPatterns.builder.item;

public class MediaItem {
	private String name;

	public MediaItem(String name) {
		this.name = name;
	}
	public String toString(){
		return name;
	}
}
