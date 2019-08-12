package com.fangle.parking.tcp;

import com.fangle.parking.bo.CameraBo;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.AttributeKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.Charset;

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

        // 首先，netty通过ServerBootstrap启动服务端
        Bootstrap client = new Bootstrap();

        //第1步 定义线程组，处理读写和链接事件，没有了accept事件
        EventLoopGroup group = new NioEventLoopGroup();
        client.group(group );

        //第2步 绑定客户端通道
        client.channel(NioSocketChannel.class);

        //第3步 给NIoSocketChannel初始化handler， 处理读写事件
        client.handler(new ChannelInitializer<NioSocketChannel>() {  //通道是NioSocketChannel
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                //字符串编码器，一定要加在SimpleClientHandler 的上面
                ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(1024,5,2,10,0));
                ch.pipeline().addLast(new StringDecoder(Charset.forName("UTF-8")));
                //找到他的管道 增加他的handler
                ch.pipeline().addLast(new SimpleClientHandler());
            }
        });

        //连接服务器
//        ChannelFuture future1 = client.connect("192.168.6.243", 8131).sync();
        ChannelFuture future1 = client.connect("localhost", 8006).sync();
        log.info("channel1 id {}", future1.channel().id());
        sendCmd(future1.channel(),"{\"cmd\" :\"getsn\"}");
//        ChannelFuture future2 = client.connect("192.168.6.244", 8131).sync();
//        log.info("channel2 id {}", future2.channel().id());

        //发送数据给服务器
//        future1.channel().writeAndFlush("{\"cmd\" :\"getsn\"}");
//        future2.channel().writeAndFlush(cameraBo.toString()+"\r\n");

        //当通道关闭了，就继续往下走
        future1.channel().closeFuture().sync();
//        future2.channel().closeFuture().sync();

        //接收服务端返回的数据
//        AttributeKey<String> key = AttributeKey.valueOf("ServerData");
//        Object result = future.channel().attr(key).get();
//        System.out.println(result.toString());
    }

    public static boolean sendCmd(Channel channel, String cmd){
        int len =  cmd.getBytes().length;
        byte[] header = {'V','Z',0,0,0,0,0,0};
        header[4] += (byte) ((len >>24) & 0xFF);
        header[5] += (byte) ((len >>16) & 0xFF);
        header[6] += (byte) ((len >>8) & 0xFF);
        header[7] += (byte) (len & 0xFF);
        channel.writeAndFlush(Unpooled.copiedBuffer(header));
        channel.writeAndFlush(cmd);
        return true;
    }
}