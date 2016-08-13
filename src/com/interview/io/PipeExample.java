package com.interview.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeExample {
	public static void main(String[] args) throws Exception {
		PipedOutputStream out = new PipedOutputStream();
		PipedInputStream in= new PipedInputStream(out);
		
		
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					//System.out.println("this is thread1");
					out.write("Hello World,pip!".getBytes());
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					//System.out.println("this is thread2");
					int data = in.read();
					while(data != -1){
						System.out.print((char)data);
						data = in.read();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		
		thread1.start();
		thread2.start();
	}
}
