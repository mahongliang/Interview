package com.interview.ino;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
	public static void main(String[] args) throws IOException {
		RandomAccessFile aFile = new RandomAccessFile("data/ino-data.txt", "rw");
		FileChannel inChannel = aFile.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(48);
		int bytesRead = inChannel.read(buffer);//1 read into buffer
		while(bytesRead != -1){
			System.out.println("Read "+bytesRead);
			buffer.flip();//2 make buffer ready for read
			
			while(buffer.hasRemaining()){
				System.out.print((char)buffer.get());//3 read 1 byte at a time
			}
			buffer.clear();//4 make buffer ready for writing;
			bytesRead = inChannel.read(buffer);
		}
		aFile.close();
		
	}
}
