package com.fangle.parking;

import com.fangle.parking.tcp.NettyTcpClient;
import com.fangle.parking.tcp.TcpClient;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.C;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Gentel
 * @description
 * @create 2019-08-01 8:40
 */

@Slf4j
@Configuration
@ConditionalOnExpression("${tcp.run:true}")
public class TcpConfig {

    @Bean(initMethod = "start")
    public TcpClient tcpClient(){
        return new NettyTcpClient();
    }
}