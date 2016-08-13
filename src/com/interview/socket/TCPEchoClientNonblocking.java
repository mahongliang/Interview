package com.interview.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class TCPEchoClientNonblocking {

	public static void main(String[] args) throws IOException {
		if ((args.length < 2) || (args.length > 3))
			throw new IllegalArgumentException("参数不正确");
		// 第一个参数作为要连接的服务端的主机名或IP
		String server = args[0];
		// 第二个参数为要发送到服务端的字符串
		byte[] argument = args[1].getBytes();
		// 如果有第三个参数，则作为端口号，如果没有，则端口号设为7
		int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;
		
		SocketChannel clntChan = SocketChannel.open();
		clntChan.configureBlocking(false);
		if (!clntChan.connect(new InetSocketAddress(server, servPort))) {
			while(!clntChan.finishConnect()){
				System.out.println(".");
			}
		}
		
		System.out.println();
		ByteBuffer writebuf = ByteBuffer.wrap(argument);
		ByteBuffer readbuf = ByteBuffer.allocate(argument.length);
		
		int totalByteRcvd=0;
		int bytesRcvd;
		
		while(totalByteRcvd < argument.length){
			if (writebuf.hasRemaining()) {
				clntChan.write(writebuf);
			}
			
			if ((bytesRcvd = clntChan.read(readbuf)) == -1) {
				throw new SocketException("Connecton close prematurely");
			}
			totalByteRcvd += bytesRcvd;
			System.out.print(".");
			
		}
		 //打印出接收到的数据  
        System.out.println("Received: " +  new String(readbuf.array(), 0, totalByteRcvd));  
        //关闭信道  
        clntChan.close();  
	}
}
