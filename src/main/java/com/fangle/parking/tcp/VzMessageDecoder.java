package com.fangle.parking.tcp;

import com.fangle.parking.Utils.VzCameraMessageUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author Gentel
 * @description 甄识相机消息解析
 * @create 2019-08-15 16:30
 */

@Slf4j
public class VzMessageDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        Object decoded = decode(ctx, in);
        if (decoded != null) {
            out.add(decoded);
        }
        in.resetReaderIndex();
        in.resetWriterIndex();
    }

    /*
     * @description 甄识相机数据解码
     * @date 2019/8/15
     * @param in
     * @return java.lang.Object
     */
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        log.info("VzCamera Message [L:" + ctx.channel().localAddress() + "] [R:" + ctx.channel().remoteAddress()+ "]:" + ByteBufUtil.hexDump(in));
        // 数据头判断
        byte[] head = new byte[2];
        in.readBytes(head);
        if ('V' != head[0] || 'Z' != head[1])
            return null;

        // 数据包类型
        int packageType = in.readByte();
        if (1 != packageType && 0 != packageType)
            return null;

        // 包序号
        int packageNum = in.readByte();

        // 数据长度
        byte[] msgDateLenBuf = new byte[4];
        in.readBytes(msgDateLenBuf);
        int dateMsgLen = VzCameraMessageUtil.convMsgLen(msgDateLenBuf, 0);
        ByteBuf frame = in.slice(8, dateMsgLen);
        return frame;
    }

}