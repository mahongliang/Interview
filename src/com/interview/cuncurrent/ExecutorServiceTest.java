package com.interview.cuncurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			System.out.println("创建线程" + i);
			Runnable run = new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println("启动线程");
				}
			};
			service.execute(run);			
		}
		service.shutdown();
		service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		System.out.println("所有的线程结束");
	}

}
