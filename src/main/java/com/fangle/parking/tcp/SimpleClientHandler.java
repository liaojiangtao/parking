package com.fangle.parking.tcp;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.AttributeKey;

import java.nio.charset.Charset;

/**
 * @author Gentel
 * @description
 * @create 2019-08-08 8:22
 */
public class SimpleClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof ByteBuf) {
            String value = ((ByteBuf) msg).toString(Charset.defaultCharset());
            System.out.println(ctx.channel().id() + " 服务器端返回的数据:" + value);
        }

//        AttributeKey<String> key = AttributeKey.valueOf("ServerData");
//        ctx.channel().attr(key).set("客户端处理完毕");

        //把客户端的通道关闭
//        ctx.channel().close();
    }

}