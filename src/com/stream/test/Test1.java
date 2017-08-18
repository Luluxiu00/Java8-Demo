package com.stream.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test1 {

	public static void main(String[] args) {
	    Property p1 = new Property("叫了个鸡", 1000, 500, 2);
	    Property p2 = new Property("张三丰饺子馆", 2300, 1500, 3);
	    Property p3 = new Property("永和大王", 580, 3000, 1);
	    Property p4 = new Property("肯德基", 6000, 200, 4);
	    List<Property> properties = Arrays.asList(p1, p2, p3, p4);
	    //获取最近的店铺
	    Collections.sort(properties, (x, y) -> x.distance.compareTo(y.distance));
	    String name = properties.get(0).name;
	    System.out.println("距离我最近的店铺是:" + name);
	    
	    //Stream操作
	    String name2 = properties.stream()
	    		.sorted(Comparator.comparingInt(x -> x.distance))
	    		.findFirst()
	    		.get().name;
	    System.out.println("距离我最近的店铺是:" + name2);
	    
	    
	    /**
	     * 获取月销量大于1000的店铺个数
	     */
	    //使用for循环进行迭代
	    int count = 0;
	    for (Property property : properties) {
	        if(property.sales > 1000){
	            count++;
	        }
	    }
	    System.out.println("月销量大于1000的店铺个数为: " + count);
	    
	    //Stream操作
	    int count2 = (int) properties.stream().filter(x -> x.sales > 1000).count();
	    System.out.println("月销量大于1000的店铺个数为: " + count2);
	    
	    /**
	     * 我们需要筛选出价格最低的店铺:
	     */
	    Property property = properties.stream()
	    	            .min(Comparator.comparingInt(p -> p.priceLevel))
	    	            .get();
	    System.out.println(property);
	    
	    /**
	     * 获取距离我最近的2个店铺
	     */
	    List<Property> properties2 = properties.stream()
	                .sorted(Comparator.comparingInt(x -> x.distance))
	                .limit(2)
	                .collect(Collectors.toList());
	    System.out.println(properties2);
	    

		/**
		 * 获取所有店铺的名称
		 */
		List<String> names = properties.stream()
                      .map(p -> p.name)
                      .collect(Collectors.toList());
		System.out.println(names);
		
		/**
		 * 获取每个店铺的价格等级
		 */
		Map<String, Integer> map = properties.stream()
		        .collect(Collectors.toMap(Property::getName, Property::getPriceLevel));
		System.out.println(map);
		
		/**
		 * 所有价格等级的店铺列表
		 */
		Map<Integer, List<Property>> priceMap = properties.stream()
		                .collect(Collectors.groupingBy(Property::getPriceLevel));
		System.out.println(priceMap);
	}

}
