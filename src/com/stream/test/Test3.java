package com.stream.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Test3 {

	public static void main(String[] args) {
		List<List<String>> lists = new ArrayList<>();
        lists.add(Arrays.asList("apple", "click"));
        lists.add(Arrays.asList("boss", "dig", "qq", "vivo"));
        lists.add(Arrays.asList("c#", "biezhi"));
        
        //要做的操作是获取这些数据中长度大于2的单词个数

        long count = lists.stream()
                .flatMap(Collection::stream)
                .filter(str -> str.length() > 2)
                .count();
        System.out.println(count);
	}
}
