package com.somnus.designPatterns.bridge;

public class Client {

    public static void main(String[] args) {
        Image image = new JPGImage();  
        ImageImp imp = new WindowsImp();  
        image.setImageImp(imp);  
        image.parseFile("小龙女");
    }

}
