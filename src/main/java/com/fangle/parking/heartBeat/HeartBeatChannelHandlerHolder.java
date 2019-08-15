package com.fangle.parking.heartBeat;

import io.netty.channel.ChannelHandler;

public interface HeartBeatChannelHandlerHolder {
    ChannelHandler[] handlers();
}
