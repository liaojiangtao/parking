package com.fangle.parking.service;

import com.fangle.parking.entity.CameraInfo;

import java.util.List;

public interface CameraInfoService {
    /**
     * @description 查询所有相机
     * @date 2019/7/30
     * @param
     * @return java.util.List<com.fangle.parking.entity.CameraInfo>
     */
    List<CameraInfo> queryAll();
}
