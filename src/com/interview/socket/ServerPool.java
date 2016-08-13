package com.interview.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerPool {
	private static final int THREADPOOLSIZE = 2;  

	public static void main(String[] args) throws IOException {
		final ServerSocket server = new ServerSocket(20006);
		
		for (int i = 0; i < THREADPOOLSIZE; i++) {
			Thread thread = new Thread(new Runnable() {			
				@Override
				public void run() {
					// TODO Auto-generated method stub
					while(true){
						try {
							Socket client = server.accept();
							System.out.println("连接成功");
							ServerThread.execute(client);
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					
				}
			});
			thread.start();
		}
	}

}
