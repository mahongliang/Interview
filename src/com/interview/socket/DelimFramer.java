package com.interview.socket;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DelimFramer implements Framer{

	
	private InputStream in;
	private static final byte DELIMTER = '\n';
	
	
	public DelimFramer(InputStream in) {
		this.in = in;
	}
	@Override
	public void frameMsg(byte[] message, OutputStream out) throws IOException {
		// TODO Auto-generated method stub
		for (byte b : message) {
			if (b == DELIMTER) {
				throw new IOException("Message contains delimter");
			}
		}
		out.write(message);
		out.write(DELIMTER);
		out.flush();
	}
	
	

	@Override
	public byte[] nextMsg() throws IOException {
		// TODO Auto-generated method stub
		ByteArrayOutputStream messageBuffer = new ByteArrayOutputStream();
		int nextByte;
		while((nextByte = in.read()) != DELIMTER){
			if (nextByte == -1) {
				if (messageBuffer.size() == 0) {
					return null;
				}else {
					throw new EOFException("Non-empty message without delimter");
				}			
			}
			messageBuffer.write(nextByte);	
		}
		return messageBuffer.toByteArray();		
	}
	
	
}
