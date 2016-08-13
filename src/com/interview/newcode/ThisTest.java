package com.interview.newcode;

public class ThisTest {

}

class A{
	private int a;
	protected int b;
	public int c;
}

class B extends A{
	public void print(){
		System.out.println(this.b);
		System.out.println(this.c);	
		
	}
}
