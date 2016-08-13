package com.interview.cuncurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	public static void main(String[] args) {
		
		ExecutorService service = Executors.newCachedThreadPool();
		//只能5个线程同时访问
		final Semaphore semaphore = new Semaphore(5);
		
		//模拟20个客户端
		for (int i = 0; i < 20; i++) {
			int num = i;
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						semaphore.acquire();
						System.out.println("Accessing: "+num);
						Thread.sleep((long)(Math.random()*10000));
						
						semaphore.release();
						System.out.println("Releasing " + num);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			service.execute(runnable);
			System.out.println("exec");
		}
		//非阻塞
		service.shutdown();
		System.out.println("shutdown");
	}

}
