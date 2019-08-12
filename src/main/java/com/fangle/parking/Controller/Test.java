package com.fangle.parking.Controller;

import com.fangle.parking.bo.CameraBo;
import com.fangle.parking.dto.CameraDto;
import com.fangle.parking.entity.CameraInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Gentel
 * @description 测试
 * @create 2019-07-30 19:05
 */

@Slf4j
@RestController
@RequestMapping(value = "/test")
public class Test {

    @Autowired
    CameraBo cameraBo;

    @GetMapping
    String test(){
        return "test";
    }

    @GetMapping(value = "/cameraInfos")
    public CameraBo cameraInfos(){
        return cameraBo;
    }

    @PostMapping(value = "addCamera")
    public String addCamera(@RequestBody CameraDto camera){
        cameraBo.getCameras().add(camera);
        return "{\"errNo\":\"200\",\"errMessage\":\"OK\",\"data\":\"{\\\"resultCode\\\":200,\\\"resultMessage\\\":\\\"SUCCESS\\\"}\"}";
    }
}