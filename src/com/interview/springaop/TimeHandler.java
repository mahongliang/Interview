package com.interview.springaop;

import java.lang.reflect.Method;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeHandler implements InvocationHandler{

	public Object target;
	public TimeHandler(Object target) {
		// TODO Auto-generated constructor stub
		this.target=target;
	}
	@Override
	public void invoke(Object o, Method m) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println("开始时间："+df.format(new Date()));// new Date()为获取当前系统时间
		
		try {
			m.invoke(target);
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("结束时间："+df.format(new Date()));// new Date()为获取当前系统时间
		System.out.println("耗时 ："+(end-start)/1000);
		
	}
	

}
