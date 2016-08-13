package com.interview.jvm;

public class ConstClass {

	static{
		System.out.println("ConstClass init!");
	}
	
//	public static final String HelloWord = "hello world";
	public static final String HelloWord = new String("hello world");
	
	
}
