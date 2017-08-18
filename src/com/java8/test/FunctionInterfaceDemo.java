package com.java8.test;

import java.util.function.Function;

/**
 * 函数性接口示例 2
 * @author LX
 *
 */
public class FunctionInterfaceDemo {

	public static Integer convert(String str, Function<String, Integer> function) {
	    return function.apply(str);
	}
	
	public static void main(String[] args) {
	    Integer value = convert("28", x -> Integer.parseInt(x));
	    System.out.println(value);
	}
}