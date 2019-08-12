package com.fangle.parking.bo;

import com.fangle.parking.dto.CameraDto;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * @author Gentel
 * @description 相机信息
 * @create 2019-07-31 17:09
 */

@Data
public class CameraBo {
    List<CameraDto> cameras = Lists.newArrayList();
}