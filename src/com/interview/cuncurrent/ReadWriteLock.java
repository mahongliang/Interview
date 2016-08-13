package com.interview.cuncurrent;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ReadWriteLock {
	
	
	private Map<Thread, Integer> readingThreads = new HashMap<>();
	

	private int writers=0;
	private int writeRequests = 0;
	
	private Thread writingThread = null;
	
	public synchronized void lockRead() throws InterruptedException{
		Thread callingThread = Thread.currentThread();
		while(!canGreantReadAccess(callingThread)){
			wait();
		}

		readingThreads.put(callingThread, getReadAccessCount(callingThread)+1);
	}
	
	public synchronized void unlockRead(){
		Thread callingThread = Thread.currentThread();
		int accessCount=getReadAccessCount(callingThread);
		if (accessCount == 1) {
			readingThreads.remove(callingThread);
		}else {
			readingThreads.put(callingThread, accessCount-1);
		}
		notifyAll();
	}
	
	public synchronized void lockWrite() throws InterruptedException{
		writeRequests++;
		Thread callingThread = Thread.currentThread();
		while(!canGrantWriteAccess(callingThread)){
			wait();
		}
		
		writeRequests--;
		writers--;
		writingThread = callingThread;
	}
	
	public synchronized void unlockWrite(){
		writers--;
		if (writers == 0) {
			writingThread=null;
		}
		notifyAll();
	}
	
	private boolean canGrantWriteAccess(Thread callingThread){
		if (isOnlyReader(callingThread)) {
			return true;
		}
		if (hasReader()) {
			return false;
		}
		
		if (writingThread == null) {
			return true;
		}
		
		if (!isWriter(callingThread)) {
			return false;
		}
		
		return true;
	}
	
	private boolean isWriter(Thread callingThread){
		return writingThread == callingThread;
	}
	
	private boolean hasReader(){
		return readingThreads.size()>0;
	}
	private boolean canGreantReadAccess(Thread callingThread){
		if (writers>0) {
			return false;
		}
		if (isReader(callingThread)) {
			return true;
		}
		
		if (writeRequests>0) {
			return false;
		}
		
		return true;
	}
	
	private int getReadAccessCount(Thread callingThread){
		Integer accessCount = readingThreads.get(callingThread);
		if (accessCount == null) {
			return 0;
		}
		return accessCount.intValue();
	}
	
	private boolean isReader(Thread callingThread){
		return readingThreads.get(callingThread) != null;
		
	}
	private boolean isOnlyReader(Thread callingThread){
		return getReadAccessCount(callingThread) == 1 &&readingThreads.get(callingThread) != null;
	}
	

}
