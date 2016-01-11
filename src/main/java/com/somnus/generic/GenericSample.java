package com.somnus.generic;

import java.util.List;

/** 
 * @Description: TODO
 * @author Somnus
 * @date 2016年1月11日 下午4:54:51 
 * @version V1.0 
 */
public class GenericSample<E extends Flower> {
    
    private List<E> result;
    
    public <R extends Flower> void add(R r){
        
    }
    public <T> void add(List<T> list){
        
    }
    
    public <S extends Flower> void save(List<S> list){
        if(list != null && list.size()>0){
            S cat = (S) list.get(0);
        }
    }
    /*public <K super Rose> void save2(List<K> list){
        if(list != null && list.size()>0){
            K k = (K) list.get(0);
        }
    }*/
    
}
class Flower{
    
}
class Rose extends Flower{
    
}
