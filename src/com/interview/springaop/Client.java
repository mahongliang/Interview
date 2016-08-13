package com.interview.springaop;

public class Client {

	public static void main(String[] args) throws Exception {
		UserMgr mgr = new UserMgrImpl();
		
		
		//为用户管理添加事务处理
		InvocationHandler h = new TransactionHandler(mgr);
		UserMgr userMgr =(UserMgr) Proxy.newProxyInstance(UserMgr.class, h);
		
		
		//为用户管理添加显示执行时间的功能
		InvocationHandler timehandler = new TimeHandler(userMgr);
		userMgr =(UserMgr) Proxy.newProxyInstance(UserMgr.class, timehandler);
		
		
		userMgr.addUser();
		System.out.println("\r\n==========华丽的分割线==========\r\n"); 
		userMgr.delUser();
	}
}
