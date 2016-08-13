package com.interview.designpattern;

import java.security.KeyStore.PrivateKeyEntry;

class TaskManager{
	private static TaskManager tm = null;
	private TaskManager(){
	}
	
	public static TaskManager getInstance(){
		if (tm == null) {
			return new TaskManager();
		}
		return tm;
	}
}

class EagerSingleton{
	private EagerSingleton(){}
	private static final EagerSingleton instance = new EagerSingleton();
	public static EagerSingleton getInstance(){
		return instance;
	}
}

class LazySingleton{
	private LazySingleton(){}
	private static LazySingleton instance = null;
	synchronized public static LazySingleton getInstance(){
		if (instance==null) {
			instance = new LazySingleton();
		}
		return instance;
	}
}

class StaticinnerSingleton{
	private StaticinnerSingleton(){}
	private static class HolderClass{
		private final static StaticinnerSingleton instance = new StaticinnerSingleton();
	}
	
	public static StaticinnerSingleton getInstance(){
		return HolderClass.instance;
	}
}


public class SingletonTest {
	public static void main(String[] args) {
		StaticinnerSingleton s1 = StaticinnerSingleton.getInstance();
		StaticinnerSingleton s2 = StaticinnerSingleton.getInstance();
		System.out.println(s1==s2);
	}
}
