package com.interview.questions;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class StaticFainal {

	// public static Random random = new Random(50);
	// public String str1 = "1234";
	// public final String str = str1;
	//
	//
	// public static void main(String[] args) {
	// StaticFainal test = new StaticFainal();
	// System.out.println(test.str);
	//
	//
	// test.str1 = "123";
	// System.out.println(test.str);
	//
	// test.str1 ="1";
	// System.out.println(test.str);
	// }

	private static Random rand = new Random(47); // 47作为随机种子，为的就是产生随机数。
	


	private final int a = rand.nextInt(20);

	private static final int B = rand.nextInt(20);

	public static void main(String[] args) {
		StaticFainal sf = new StaticFainal();
		System.out.println("sf : " + "a=" + sf.a);
		System.out.println("sf : " + "B=" + sf.B);
		System.out.println("------------------------------");
		StaticFainal sf1 = new StaticFainal();
		System.out.println("sf1 : " + "a=" + sf1.a);
		System.out.println("sf1 : " + "B=" + sf1.B);
	}
}
