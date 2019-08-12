package com.fangle.parking;

import com.fangle.parking.bo.CameraBo;
import com.fangle.parking.dto.CameraDto;
import com.fangle.parking.entity.CameraInfo;
import com.fangle.parking.repository.CameraInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"com.fangle"})
public class ParkingApplication {

    @Autowired
    private CameraInfoRepository cameraInfoRepository;

    public static void main(String[] args) {
        SpringApplication.run(ParkingApplication.class, args);
    }

    @Bean
    public CameraBo cameraInfo(){
        CameraBo cameras = new CameraBo();
        List<CameraInfo> cameraInfos = cameraInfoRepository.findAll();
        CameraDto cameraDto = null;
        for (CameraInfo camerainfo: cameraInfos) {
            cameraDto = new CameraDto(camerainfo.getIp(), camerainfo.getPort(), camerainfo.getManufacturerId(), camerainfo.getDeviceStatus());
            cameras.getCameras().add(cameraDto);
        }
        return cameras;
    }
}
