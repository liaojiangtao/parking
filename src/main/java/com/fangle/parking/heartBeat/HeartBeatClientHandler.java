package com.fangle.parking.heartBeat;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

import java.util.Date;

/**
 * @author Gentel
 * @description
 * @create 2019-08-15 21:40
 */

@Sharable
public class HeartBeatClientHandler extends ChannelInboundHandlerAdapter{
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("激活时间是："+new Date());
        System.out.println("HeartBeatClientHandler channelActive");
        ctx.fireChannelActive();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("停止时间是："+new Date());
        System.out.println("HeartBeatClientHandler channelInactive");
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String message = (String) msg;
        System.out.println(message);
        if (message.equals("Heartbeat")) {
            ctx.write("has read message from server");
            ctx.flush();
        }
        ReferenceCountUtil.release(msg);
    }
}