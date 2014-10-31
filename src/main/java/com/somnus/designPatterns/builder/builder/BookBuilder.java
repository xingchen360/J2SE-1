package com.somnus.designPatterns.builder.builder;

import com.somnus.designPatterns.builder.item.MediaItem;
import com.somnus.designPatterns.builder.media.Book;
import com.somnus.designPatterns.builder.media.Media;

public class BookBuilder extends MediaBuilder {
	private Book book;
	
	public void buildBase() {
		System.out.println("Building book framework");
		book = new Book();
	}

	public void addMediaItem(MediaItem chapter) {
		System.out.println("Adding chapter " + chapter);
		book.add(chapter);
	}

	public Media getFinishedMedia() {
		return book;
	}
}
