package com.somnus.enums;
/**
 * 枚举像普通的类一样可以添加属性和方法，可以为它添加静态和非静态的属性或方法
 * @author somnus
 */
public enum SeasonEnum {
	//注：枚举写在最前面，否则编译出错
    spring, summer, autumn, winter;

    private final static String position = "test";

    public static SeasonEnum getSeason() {
        if ("test".equals(position))
            return spring;
        else
            return winter;
    }
}
