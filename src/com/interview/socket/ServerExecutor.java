package com.interview.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ServerExecutor {
	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket= new ServerSocket(20006);
		Socket client = null;
		Executor service = Executors.newCachedThreadPool();
		boolean f = true;
		while (f) {
			client = serverSocket.accept();
			System.out.println("connect success");
			service.execute(new ServerThread(client));
		}
		serverSocket.close();
	}

}
