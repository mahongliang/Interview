package com.interview.springaop;

import java.lang.reflect.Method;

public class TransactionHandler implements InvocationHandler{
	
	private Object target;
	public TransactionHandler(Object target) {
		// TODO Auto-generated constructor stub
		this.target=target;
	}

	@Override
	public void invoke(Object o, Method m) {
		// TODO Auto-generated method stub
		System.out.println("开启事务。。。。");
		try {
			m.invoke(target);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("提交事务。。。");
	}
	
}
