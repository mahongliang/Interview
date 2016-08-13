package com.interview.cuncurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
	public static void main(String[] args) throws InterruptedException {
		final CountDownLatch begin = new CountDownLatch(1);
		final CountDownLatch end = new CountDownLatch(10);
		
		final ExecutorService exec = Executors.newFixedThreadPool(10);
		
		for (int i = 0; i < 10; i++) {
			final int no = i+1;
			
			Runnable run = new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						begin.await();
						Thread.sleep((long)(Math.random()*10000));
						System.out.println("No "+no+" arrived");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						end.countDown();
					}
				}
			};
			exec.submit(run);
		}
		System.out.println("Game start");
		//begin减一，开始游戏
		begin.countDown();
		
		//等待end变为0
		end.await();
		System.out.println("Game end");
		exec.shutdown();
	}

}
