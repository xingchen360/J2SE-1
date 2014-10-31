package com.somnus.designPatterns.builder.builder;

import com.somnus.designPatterns.builder.item.MediaItem;
import com.somnus.designPatterns.builder.media.Media;

public abstract class MediaBuilder {
	public abstract void buildBase();
	public abstract void addMediaItem(MediaItem m);
	public abstract Media getFinishedMedia();
}
