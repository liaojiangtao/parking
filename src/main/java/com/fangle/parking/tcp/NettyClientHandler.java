package com.fangle.parking.tcp;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * @author Gentel
 * @description
 * @create 2019-08-08 8:22
 */

@Slf4j
public class NettyClientHandler extends ChannelInboundHandlerAdapter {
    /** 客户端请求的心跳命令  */
    private static final byte[] HEARTBEAT_SEQUENCE = {'V','Z',1,0,0,0,0,0};

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object obj) throws Exception {
        if (obj instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) obj;
            if (IdleState.WRITER_IDLE.equals(event.state())) {  //如果写通道处于空闲状态,就发送心跳命令
                ctx.channel().writeAndFlush(Unpooled.copiedBuffer(HEARTBEAT_SEQUENCE));
            }
        }
    }
}