package com.java8.test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {  
      
    public static void main(String[] args) throws InterruptedException {  
    	ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
    	//value值不能为null,会报空指针
		map.put("key", "123");
		System.out.println(map.size());
		System.out.println(map.get("key"));
		
		HashMap<String, Object> map2 = new HashMap<>();
		map2.put("key", null);
		System.out.println(map2.size());
		System.out.println(map2.get("key"));
    }  
}