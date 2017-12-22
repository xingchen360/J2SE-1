package com.somnus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class InitializationData {
	
	public static final Map<String, String> myMap = Collections.unmodifiableMap(new HashMap<String, String>() {
        private static final long serialVersionUID = 1L;

        {
            put("k1", "11");
            put("k2", "22");
        }
    });

    public static final List<String> myList = Collections.unmodifiableList(new ArrayList<String>() {
        private static final long serialVersionUID = 1L;

        {
            add("a");
            add("b");
        }
    });
    
    @Test
    public void map(){
    	System.out.println(JSON.toJSONString(myMap));
    }
    
    @Test
    public void list(){
    	System.out.println(myList);
    }

}
