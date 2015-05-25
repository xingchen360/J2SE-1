package com.somnus.annotation;

@AnnotationDefined(value2=EnumExample.hello)
public class AnnotationUsage {
	@AnnotationDefined(value="world" ,value2=EnumExample.world)
	public void method(){
		System.out.println("usage of annotation");
	}
	public static void main(String[] args) {
		AnnotationUsage usage = new AnnotationUsage();
		usage.method();
	}
}
