package com.interview.socket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class EchoSelectorProtocol implements TCPProtocol{
	private int bufSize;
	public EchoSelectorProtocol(int bufSize) {
		this.bufSize = bufSize;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleAccept(SelectionKey key) throws IOException {
		// TODO Auto-generated method stub
		SocketChannel clntChan =((ServerSocketChannel) key.channel()).accept();
		clntChan.configureBlocking(false);
		clntChan.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufSize));
	}

	@Override
	public void handleRead(SelectionKey key) throws IOException {
		// TODO Auto-generated method stub
		SocketChannel clntChan = (SocketChannel) key.channel();
		ByteBuffer buf = (ByteBuffer) key.attachment();
		
		long bytesRead = clntChan.read(buf);
		if (bytesRead == -1) {
			clntChan.close();
		}else if (bytesRead>0) {
			key.interestOps(SelectionKey.OP_READ|SelectionKey.OP_WRITE);		
		}
	}

	@Override
	public void handleWrite(SelectionKey key) throws IOException {
		// TODO Auto-generated method stub
		//获取与该信道关联的缓冲区，里面有之前读取到的数据  
	    ByteBuffer buf = (ByteBuffer) key.attachment();  
	    //重置缓冲区，准备将数据写入信道  
	    buf.flip();   
	    SocketChannel clntChan = (SocketChannel) key.channel();  
	    //将数据写入到信道中  
	    clntChan.write(buf);  
	    if (!buf.hasRemaining()){   
	    //如果缓冲区中的数据已经全部写入了信道，则将该信道感兴趣的操作设置为可读  
	      key.interestOps(SelectionKey.OP_READ);  
	    }  
	    //为读入更多的数据腾出空间  
	    buf.compact();   
	}

}
