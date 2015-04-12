package com.somnus.designPatterns.composite;

public class Client {
	public static void main(String[] args) {
		AbstractFile f2,f3,f4,f5;
		Folder f1 = new Folder("我的收藏");
		f2 = new ImageFile("mm.jpg");
		f3 = new TextFile("123.txt");
		f1.add(f2);
		f1.add(f3);
		
		Folder f11 = new Folder("我的电影");
		f4 = new VideoFile("笑傲江湖.avi");
		f5 = new VideoFile("神雕侠侣.mp4");
		f11.add(f4);
		f11.add(f5);
		
		f1.add(f11);
		
		f1.killVirus();
		
		
	}
}
