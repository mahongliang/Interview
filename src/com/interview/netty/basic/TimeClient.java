package com.interview.netty.basic;




import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TimeClient {

	public static void main(String[] args) throws InterruptedException {
		int port = 8080;
		if (args != null && args.length > 0) {
		    try {
			port = Integer.valueOf(args[0]);
		    } catch (NumberFormatException e) {
			// 采用默认值
		    }
		}
		new TimeClient().connect(port, "127.0.0.1");
	}

	public void connect(int port, String host) throws InterruptedException {
		// TODO Auto-generated method stub
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class)
				.option(ChannelOption.TCP_NODELAY, true)
				.handler(new ChannelInitializer<SocketChannel>() {

					@Override
					protected void initChannel(SocketChannel arg0) throws Exception {
						// TODO Auto-generated method stub
						arg0.pipeline().addLast(new TimeClientHandler());
					}
				});
			
			ChannelFuture f = b.connect(host,port).sync();
			f.channel().closeFuture().sync();
		} finally {
			// 优雅退出，释放NIO线程组
		    group.shutdownGracefully();
		}
	}
}
