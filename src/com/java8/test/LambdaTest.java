package com.java8.test;

public class LambdaTest {

	public static void main(String[] args) {
		//普通方法
		Runnable r = new Runnable() {
		    @Override
		    public void run() {
		        System.out.println("do something.");      
		    }
		};

		//lambda
		Runnable r2 = () -> System.out.println("函数式编程!!!");
		r.run();
		r2.run();
		
	}
}
