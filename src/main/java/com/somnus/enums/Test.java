package com.somnus.enums;

public class Test {
	public static void main(String[] args) {
		//枚举是一种类型，用于定义变量，以限制变量的赋值；赋值时通过“枚举名.值”取得枚举中的值
        ColorEnum colorEnum = ColorEnum.blue;
        switch (colorEnum) {
            case red:
                System.out.println("color is red");
                break;
            case green:
                System.out.println("color is green");
                break;
            case yellow:
                System.out.println("color is yellow");
                break;
            case blue:
                System.out.println("color is blue");
                break;
        }
        
        //遍历枚举
        System.out.println("遍历ColorEnum枚举中的值");
        for(ColorEnum color : ColorEnum.values()){
            System.out.println(color);
        }
        
        //获取枚举的个数
        System.out.println("ColorEnum枚举中的值有:"+ColorEnum.values().length+"个");
        
        //获取枚举的索引位置，默认从0开始
        System.out.println("索引位置："+ColorEnum.red.ordinal());//0
        System.out.println("索引位置："+ColorEnum.green.ordinal());//1
        System.out.println("索引位置："+ColorEnum.yellow.ordinal());//2
        System.out.println("索引位置："+ColorEnum.blue.ordinal());//3
        
        //枚举默认实现了java.lang.Comparable接口
        System.out.println("类型比较："+ColorEnum.red.compareTo(ColorEnum.green));//-1
        
        System.out.println("/************************************************************************************************************/");
        System.out.println("季节为：" + SeasonEnum.getSeason());
        
        System.out.println("/************************************************************************************************************/");
        for(GenderEnum gender : GenderEnum.values()){
            System.out.println("迭代得到的值："+gender.value);
        }
        
        GenderEnum genum = GenderEnum.getByCode("0");
        if(genum.getValue().equals(GenderEnum.MAN.getValue())){
            System.out.println("true");
        }
       
        System.out.println("/************************************************************************************************************/");
        for(OrderStateEnum order : OrderStateEnum.values()){
            System.out.println(order.getName());
        }
	}
}
