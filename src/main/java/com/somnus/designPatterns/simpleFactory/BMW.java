package com.somnus.designPatterns.simpleFactory;

public abstract class BMW {
    
}
class BMW320 extends BMW {
    public BMW320() {
        System.out.println("制造-->BMW320");
    }
}
class BMW523 extends BMW{
    public BMW523(){
        System.out.println("制造-->BMW523");
    }
}