package com.fangle.parking.tcp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Gentel
 * @description 通道处理器
 * @create 2019-08-15 20:47
 */

@Slf4j
public class ClientChannelHandler extends SimpleChannelInboundHandler {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {

    }


    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        log.info("客户端连接断开"+"[L:" + ctx.channel().localAddress() + "] [R:" + ctx.channel().remoteAddress()+ "]:");

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("客户端连接断开"+"[L:" + ctx.channel().localAddress() + "] [R:" + ctx.channel().remoteAddress()+ "]:");
    }
}