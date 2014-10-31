package com.somnus.annotation;

public @interface AnnotationDefined {
	String value() default "hello";
	EnumExample value2();
}
enum EnumExample
{
	hello, world, wellcome;
}