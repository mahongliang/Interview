package com.interview.newcode;

public class ReturnTest {
	public static void main(String[] args) {
	//	System.out.println(ReturnTest.returnTest());
//		Integer i01=59;
//		int i02=59;
//		Integer i03=Integer.valueOf(59);
//		Integer i04=new Integer(59);
//		System.out.println(i01==i02);//正确
//		System.out.println(i01==i03);//正确，都指向IntegerCache[59-(-128)]对象
//		System.out.println(i03==i04);//错误，引用指向的对象地址不同
//		System.out.println(i02==i04);//正确
		
		System.out.println((93&-8));
//		int a=11111;
//		Integer b = new Integer(11111);
//		Integer c = 11111;
//		
//		
//		System.out.println(a==b);
//		System.out.println(b==c);
//		System.out.println(a==c);
	}

	public static int returnTest()
	{
		int a=0;
	    try
	    {
	    	int b = 0;
	    	int c= a/b;
	    	return a++;
	    }
	    catch (Exception e)
	    {
	    	System.out.println(e.getMessage());
	    	return a++;
	    }
	    finally
	    {
	    	System.out.println("fainall");
	        return a;
	    }
//	    return false;
	}
}
