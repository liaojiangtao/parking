package com.fangle.parking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author Gentel
 * @description 相机dto
 * @create 2019-07-31 17:32
 */

@Data
@ToString
@AllArgsConstructor
public class CameraDto {
    private String ip;
    private Integer port;
    private Integer type;
    private Integer deviceStatus;
}