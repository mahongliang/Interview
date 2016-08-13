package com.interview.netty.msgpack;

import com.interview.netty.codec.serializable.UserInfo;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author lilinfeng
 * @date 2014年2月14日
 * @version 1.0
 */
public class EchoClientHandler extends ChannelHandlerAdapter {
	
	private final int sendNumber;
	

	/**
	 * Creates a client-side handler.
	 */
	public EchoClientHandler(int sendNumber) {
		this.sendNumber = sendNumber;
	}
	
	private UserInfo[] UserInfo(){
		UserInfo [] userInfos = new UserInfo[sendNumber];
		UserInfo userInfo = null;
		for (int i = 0; i < userInfos.length; i++) {
			userInfo = new UserInfo();
			userInfo.setUserID(i);
			userInfo.setUserName("ABCDEFG ----> "+i);
			userInfos[i] = userInfo;
		}
		return userInfos;
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) {
		UserInfo[] infos= UserInfo();
		for (UserInfo userInfo : infos) {
			ctx.write(userInfo);
		}
		ctx.flush();
		
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("Client receive the msgpack message : "+msg);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}