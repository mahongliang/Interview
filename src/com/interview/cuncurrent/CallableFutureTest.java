package com.interview.cuncurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("start main thread");
		final ExecutorService exec = Executors.newFixedThreadPool(5);
		Callable<String> callable = new Callable<String>() {

			@Override
			public String call() throws Exception {
				System.out.println("start new thread");
				Thread.sleep(1000*5);
				System.out.println("end new thread");
				return "some value.";
			}
		};
		
		Future<String> task = exec.submit(callable);
		//Thread.sleep(1000*2);
		System.out.println(task.get());//阻塞当前线程，即主线程，并等待子线程结束
		exec.shutdown();
		
		System.out.println("end main thread");
	}
}
