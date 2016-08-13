package com.interview.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {

	private Socket client;

	public Server(Socket client) {
		// TODO Auto-generated constructor stub
		this.client = client;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			PrintStream out = new PrintStream(client.getOutputStream());
			BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
			boolean flag = true;
			while (flag) {
				String str = buf.readLine();
				if (str == null || "".equals(str)) {
					flag = false;
				} else {
					out.println("echo: " + str);
				}

			}
			
			out.close();
			client.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(20006);
		Socket client = null;
		boolean isRun = true;
		while(isRun){
			client = serverSocket.accept();
			System.out.println("与客户端连接成功： ");
			new Thread(new Server(client)).start();
		}
		serverSocket.close();
	}

}
