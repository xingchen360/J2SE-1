package com.somnus.designPatterns.simpleFactory;

/** 
 * @description: TODO 
 * @author yh.liu
 * date 2015年4月22日 下午1:58:25  
 */
public class Client {

    public static void main(String[] args) {
        Factory factory = new Factory();
        BMW bmw320 = factory.createBMW(320);
        BMW bmw523 = factory.createBMW(523);
    }

}
