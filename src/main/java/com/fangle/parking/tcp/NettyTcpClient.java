package com.fangle.parking.tcp;

import com.fangle.parking.Utils.VzCameraMessageUtil;
import com.fangle.parking.bo.CameraBo;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

/**
 * @author Gentel
 * @description Netty Tcp 客户端
 * @create 2019-07-29 17:56
 */

@Slf4j
public class NettyTcpClient extends TcpClient{

    @Autowired
    private CameraBo cameraBo;

    @Override
    public void start() throws InterruptedException {

    }

//    @Override
//    public void start() throws InterruptedException {
//
//        // 首先，netty通过ServerBootstrap启动服务端
//        Bootstrap client = new Bootstrap();
//
//        // 第1步 定义线程组，处理读写和链接事件，没有了accept事件
//        EventLoopGroup group = new NioEventLoopGroup();
//        client.group(group );
//
//        // 第2步 绑定客户端通道
//        client.channel(NioSocketChannel.class);
//
//        // 第3步 给NIoSocketChannel初始化handler， 处理读写事件
//        client.handler(new ChannelInitializer<NioSocketChannel>() {  //通道是NioSocketChannel
//            @Override
//            protected void initChannel(NioSocketChannel ch) throws Exception {
//                // 添加心跳
//                ch.pipeline().addLast(new IdleStateHandler(0,5,0, TimeUnit.SECONDS));
//                // 解码器
//                ch.pipeline().addLast(new VzMessageDecoder());
//                // 心跳
//                ch.pipeline().addLast(new NettyClientHandler());
//                // 掉线检测
//                ch.pipeline().addLast(new ClientChannelHandler());
//            }
//        });
//
//        // 连接服务器
//        ChannelFuture future1 = client.connect("localhost", 8001).sync();
//        ChannelFuture future2 = client.connect("localhost", 8002).sync();
////        ChannelFuture future1 = client.connect("192.168.6.243", 8131).sync();
////        ChannelFuture future2 = client.connect("192.168.6.244", 8131).sync();
//        VzCameraMessageUtil.sendCmd(future1.channel(), "{\"cmd\" :\"getsn\"}");
//        VzCameraMessageUtil.sendCmd(future2.channel(), "{\"cmd\" :\"getsn\"}");
//
////        ChannelFuture future1 = client.connect("localhost", 8001).sync();
////        ChannelFuture future2 = client.connect("localhost", 8002).sync();
////        ChannelFuture future3 = client.connect("localhost", 8003).sync();
////        ChannelFuture future4 = client.connect("localhost", 8004).sync();
//
//        // 当通道关闭了，就继续往下走
//        future1.channel().closeFuture().sync();
//        future2.channel().closeFuture().sync();
////        future2.channel().closeFuture().sync();
////        future3.channel().closeFuture().sync();
////        future4.channel().closeFuture().sync();
//
//    }
}