package com.fangle.parking.Utils;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;

/**
 * @author Gentel
 * @description 甄识相机消息工具类
 * @create 2019-08-15 17:55
 */
public class VzCameraMessageUtil {

    /**
     * @description 发送甄识消息
     * @date 2019/8/15
     * @param channel
     * @param cmd
     * @return boolean
     */
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

    /**
     * @param msgDateLenBuf
     * @param offset
     * @return int
     * @description 消息长度转换
     * @date 2019/8/15
     */
    public static int convMsgLen(byte[] msgDateLenBuf, int offset) {
        int msgDateLen = 0;
        int msgDateLenTemp = 0;
        msgDateLenTemp = (0x000000FF & ((int) msgDateLenBuf[offset]));
        msgDateLen += msgDateLenTemp << 24;
        msgDateLenTemp = (0x000000FF & ((int) msgDateLenBuf[offset + 1]));
        msgDateLen += msgDateLenTemp << 16;
        msgDateLenTemp = (0x000000FF & ((int) msgDateLenBuf[offset + 2]));
        msgDateLen += msgDateLenTemp << 8;
        msgDateLenTemp = (0x000000FF & ((int) msgDateLenBuf[offset + 3]));
        msgDateLen += msgDateLenTemp;
        return msgDateLen;
    }

}