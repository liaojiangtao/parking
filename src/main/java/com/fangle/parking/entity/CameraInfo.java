package com.fangle.parking.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Gentel
 * @description 相机信息
 * @create 2019-07-29 18:04
 */

@Data
@Table(name = "tb_camera_info")
@Entity
public class CameraInfo {

    @Id
    private Long id;
    private String ip; //ip
    private Integer port;  //端口
    private String hardwareVersion;  //硬件版本
    private String softwareVersion;  //软件版本
    private Integer manufacturerId;  //厂家Id 1：甄识 2：大华 3：海康
    private String manufacturerCode;  //厂家描述
    private Date lastOnlineTime;  //最近一次上线时间\
    private Integer deviceStatus;  //设备状态 1：启用 2：未启用 3：删除
    private Date creatTime;  //创建时间
}