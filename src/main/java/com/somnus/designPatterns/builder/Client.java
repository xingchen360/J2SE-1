package com.somnus.designPatterns.builder;

import java.util.Arrays;
import java.util.List;

import com.somnus.designPatterns.builder.builder.BookBuilder;
import com.somnus.designPatterns.builder.builder.MagazineBuilder;
import com.somnus.designPatterns.builder.item.MediaItem;
import com.somnus.designPatterns.builder.media.Media;

public class Client {
	public static void main(String[] args) {
		List input = Arrays.asList(new MediaItem[] {
				new MediaItem("item1"), new MediaItem("item2"),
				new MediaItem("item3"), new MediaItem("item4"),
				});
		
		MediaDirector buildBook = new MediaDirector(new BookBuilder());
		Media book = buildBook.produceMedia(input);
		String result = "book: " + book;
		System.out.println(result);
		
		MediaDirector buildMagazine = new MediaDirector(new MagazineBuilder());
		Media magazine = buildMagazine.produceMedia(input);
		String result2 = "magazine: " + magazine;
		System.out.println(result2);
	}
}
