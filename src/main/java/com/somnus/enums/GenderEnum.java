package com.somnus.enums;

/**
 * 实现带有构造器的枚举
 * @author Somnus
 */
public enum GenderEnum {
	//通过括号赋值,而且必须带有一个参构造器和一个属性跟方法，否则编译出错
    //赋值必须都赋值或都不赋值，不能一部分赋值一部分不赋值；如果不赋值则不能写构造器，赋值编译也出错
    MAN("0","男"), WOMEN("1","女");
    
    public final String value;
    
    public final String description;

    //构造器默认也只能是private, 从而保证构造函数只能在内部使用
    GenderEnum(String value,String description) {
        this.value = value;
        this.description = description;
    }
    
    public String getValue() {
        return value;
    }
    
    public String getDescription() {
        return description;
    }
    
    /**
     * 通过枚举<code>code</code>获得枚举
     * 
     * @param code
     * @return
     */
    public static GenderEnum getByCode(String code) {
        for (GenderEnum genum : values()) {
            if (genum.getValue().equals(code)) {

                return genum;
            }
        }
        return null;
    }
}
