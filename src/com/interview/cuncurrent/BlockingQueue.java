package com.interview.cuncurrent;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {
	private List queue = new LinkedList();
	
	private int limit = 0;
	public BlockingQueue(int limit) {
		this.limit = limit;
		// TODO Auto-generated constructor stub
	}
	
	public synchronized void enqueue(Object item) throws InterruptedException{
		while(this.queue.size() == this.limit){
			wait();
		}
		
		if (this.queue.size() == 0) {
			notifyAll();
		}
		queue.add(item);
	}
	
	public synchronized Object dequeue() throws InterruptedException{
		while(queue.size()==0){
			wait();
		}
		
		if (queue.size() == limit) {
			notifyAll();
		}
		
		return queue.remove(0);		
	}
	
	
}
