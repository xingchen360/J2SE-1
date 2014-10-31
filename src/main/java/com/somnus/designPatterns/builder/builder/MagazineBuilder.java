package com.somnus.designPatterns.builder.builder;

import com.somnus.designPatterns.builder.item.MediaItem;
import com.somnus.designPatterns.builder.media.Magazine;
import com.somnus.designPatterns.builder.media.Media;

public class MagazineBuilder extends MediaBuilder {
	private Magazine magazine;
	
	public void buildBase() {
		System.out.println("Building magazine framework");
		magazine = new Magazine();
	}

	public void addMediaItem(MediaItem article) {
		System.out.println("Adding chapter " + article);
		magazine.add(article);
	}

	public Media getFinishedMedia() {
		return magazine;
	}
}
