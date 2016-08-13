package com.interview.ino;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;

public class SelectorTest {

	public static void main(String[] args) throws IOException {

		Selector selector = Selector.open();

		SocketChannel channel = SocketChannel.open();
		channel.configureBlocking(false);
		channel.register(selector, SelectionKey.OP_READ);
		while (true) {
			int readyChannels = selector.select();
			if (readyChannels == 0) {
				continue;
			}
			Set selectedKeys = selector.selectedKeys();
			Iterator keyInterator = selectedKeys.iterator();
			while (keyInterator.hasNext()) {
				SelectionKey key = (SelectionKey) keyInterator.next();
				if (key.isAcceptable()) {

				} else if (key.isConnectable()) {

				}else if (key.isReadable()) {
					
				}else if (key.isWritable()) {
					
				}
				keyInterator.remove();
			}
		}

	}

}
