package com.interview.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

public class TCPServerSelector {

	  //缓冲区的长度  
    private static final int BUFSIZE = 256;   
    //select方法等待信道准备好的最长时间  
    private static final int TIMEOUT = 3000;   
    public static void main(String[] args) throws IOException {
    	if (args.length < 1){  
            throw new IllegalArgumentException("Parameter(s): <Port> ...");  
        }  
    	
    	Selector selector = Selector.open();
    	
    	for (String arg : args) {
			ServerSocketChannel listnChannel = ServerSocketChannel.open();
			
			listnChannel.socket().bind(new InetSocketAddress(Integer.parseInt(arg)));
			listnChannel.configureBlocking(false);
			listnChannel.register(selector, SelectionKey.OP_ACCEPT);
		}
    	
    	//创建一个实现了协议接口的对象  
        TCPProtocol protocol = new EchoSelectorProtocol(BUFSIZE);  
        
    	while(true){
    		if (selector.select(TIMEOUT) == 0) {
				System.out.print(".");
				continue;
			}
    		Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();
    		while(keyIter.hasNext()){
    			SelectionKey key = keyIter.next();
    			if (key.isAcceptable()) {
    				protocol.handleAccept(key);  
				}
    			if (key.isReadable()) {
    				 protocol.handleRead(key);  
				}
    			
    			if (key.isValid()&&key.isWritable()) {
    				protocol.handleWrite(key);  
				}
    			keyIter.remove();
    		}
    	}
    	
	}
}
