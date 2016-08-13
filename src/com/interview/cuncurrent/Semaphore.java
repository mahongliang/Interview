package com.interview.cuncurrent;

public class Semaphore {

	private boolean signal= false;
	public synchronized void take(){
		this.signal = true;
		this.notify();
	}
	
	public synchronized void release() throws InterruptedException{
		while(!this.signal){
			wait();
		}
		this.signal = false;
	}
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore();
		SendingThread sendingThread = new SendingThread(semaphore);
		RecevingThread recevingThread = new RecevingThread(semaphore);
		recevingThread.start();
		sendingThread.start();
	}
}

class SendingThread extends Thread{
	Semaphore semaphore = null;
	public SendingThread(Semaphore semaphore) {
		this.semaphore = semaphore;
	}
	
	public void run(){
		while(true){
			semaphore.take();
		}
	}
}

class RecevingThread extends Thread{
	Semaphore semaphore = null;
	public RecevingThread(Semaphore semaphore) {
		this.semaphore = semaphore;
	}
	
	public void run(){
		while(true){
			try {
				semaphore.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
