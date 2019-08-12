package com.fangle.parking.service.impl;

import com.fangle.parking.repository.CameraInfoRepository;
import com.fangle.parking.entity.CameraInfo;
import com.fangle.parking.service.CameraInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gentel
 * @description 相机信息服务
 * @create 2019-07-30 17:24
 */

@Service
public class CameraInfoServiceImpl implements CameraInfoService {

    @Autowired
    CameraInfoRepository cameraInfoRepository;

    @Override
    public List<CameraInfo> queryAll() {
        return cameraInfoRepository.findAll();
    }
}