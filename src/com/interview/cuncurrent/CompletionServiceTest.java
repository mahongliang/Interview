package com.interview.cuncurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class CompletionServiceTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exec = Executors.newFixedThreadPool(10);
		// 创建CompletionService
		CompletionService<String> service = new ExecutorCompletionService<>(exec);
		for (int i = 0; i < 5; i++) {
			final int no = i;
			Callable<String> downImg = new Callable<String>() {

				@Override
				public String call() throws Exception {
					// TODO Auto-generated method stub
					Thread.sleep((long) (Math.random() * 10000));
					return "Downloaded Image " + no;
				}
			};
			service.submit(downImg);
		}
		Thread.sleep(1000 * 2);
		System.out.println("show web content");

		for (int i = 0; i < 5; i++) {
			//获取并移除表示笑一个已完成的任务的Future，如果目前不存在这样的任务，则等带
			Future<String> task = service.take();
			System.out.println("ee");
			String img = task.get();
			System.out.println("ww");
			System.out.println(img);

		}
		System.out.println("End");
		// 关闭线程池
		exec.shutdown();
	}

}
