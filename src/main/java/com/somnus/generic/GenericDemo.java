package com.somnus.generic;

import java.util.List;

/** 
 * @Description: TODO
 * @author Somnus
 * @date 2016年1月11日 下午4:47:16 
 * @version V1.0 
 */
public class GenericDemo {
    
    private List<?> result;
    
    private List<? extends Animal> list;
    
    private List<? super Cat> list2;
    
    /*public void add(<? extends Animal> a){
        
    }*/
    public void add(List<?> list){
        
    }
    
    public void save(List<? extends Animal> list){
        if(list != null && list.size()>0){
            Cat cat = (Cat) list.get(0);
        }
    }
    public void save2(List<? super Cat> list){
        if(list != null && list.size()>0){
            Animal animal = (Animal) list.get(0);
        }
    }

}
class Animal{
    
}
class Cat extends Animal{
    
}