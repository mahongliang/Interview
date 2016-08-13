package com.interview.socket;

import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadedServer implements Runnable{

	
	protected int serverPort = 8080;
	protected ServerSocket serverSocket = null;
	protected boolean isStopped = false;
	protected Thread runningThread = null;
	
	public SingleThreadedServer(int port) {
		// TODO Auto-generated constructor stub
		this.serverPort = port;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (this) {
			this.runningThread = Thread.currentThread();
		}
		
		openServerSocket();
		while(!isStopped()){
			Socket clientSocket = null;
			try {
				clientSocket = this.serverSocket.accept();
			} catch (IOException e) {
				// TODO: handle exception
				if (isStopped()) {
					System.out.println("Server Stopped");
					return ;
				}
				throw new RuntimeException("Error accepting client connecton",e);
			}
			try {
				processClientRequest(clientSocket);
			} catch (IOException e) {
				// TODO: handle exception
			}
			
		}
		
	}
	
	private void processClientRequest(Socket clientSocket) throws IOException{
		InputStream input = clientSocket.getInputStream();
		OutputStream output = clientSocket.getOutputStream();
		long time = System.currentTimeMillis();
		output.write(("HTTP/1.1 200 OK \n\n<html><body>"+
				"Singlethread Server: "+time+
				"</body></html>").getBytes());
		
		output.close();
		input.close();
		System.out.println("Request processed: "+time);
	}
	
	private synchronized boolean isStopped(){
		return this.isStopped;
	}
	
	public synchronized void stop(){
		this.isStopped = true;
		try {
			this.serverSocket.close();
		} catch (IOException e) {
			throw new RuntimeException("Error closing server",e);
			// TODO: handle exception
		}
	}
	private void openServerSocket(){
		try {
			this.serverSocket = new ServerSocket(this.serverPort);
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	

	public static void main(String[] args) {
		SingleThreadedServer server = new SingleThreadedServer(9000);
		new Thread(server).start();
		try {
			Thread.sleep(10*1000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Stopping Server");
		//server.stop();
	}
}
