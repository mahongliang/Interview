package com.interview.cuncurrent;

public class Lock {
	private boolean isLocked = true;
	public void lock() throws InterruptedException{
		synchronized (this) {
			while(isLocked){
				wait();
			}
			isLocked = true;
		}
		
	}
	
	public synchronized void unlock(){
		isLocked = false;
		notify();
	}

}
