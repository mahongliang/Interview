package com.interview.cuncurrent;

public class PoolThread extends Thread{

	private BlockingQueue taskQueue = null;
	private boolean isStopped = false;
	public PoolThread(BlockingQueue taskQueue) {
		// TODO Auto-generated constructor stub
		this.taskQueue=taskQueue;
	}
	
	public void run(){
		while(!isStopped){
			
			try {
				Runnable runnable = (Runnable) taskQueue.dequeue();
				runnable.run();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public synchronized void doStop(){
		isStopped = true;
		this.interrupt();
	}
	
	public synchronized boolean isStopped(){
		return isStopped;
	}
	
	
}
