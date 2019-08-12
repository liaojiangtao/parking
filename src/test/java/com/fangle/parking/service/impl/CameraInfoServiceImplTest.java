package com.fangle.parking.service.impl;

import com.fangle.parking.ParkingApplication;
import com.fangle.parking.entity.CameraInfo;
import com.fangle.parking.repository.CameraInfoRepository;
import com.fangle.parking.service.CameraInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ParkingApplication.class)
public class CameraInfoServiceImplTest {

    @Autowired
    CameraInfoService cameraInfoService;

    @Autowired
    CameraInfoRepository cameraInfoRepository;

    @Test
    public void queryAll() {
        List<CameraInfo> cameraInfos = cameraInfoService.queryAll();
        Assert.assertEquals(2, cameraInfos.size());
    }


    @Test
    public void testPage(){
        //从0开区 取5条
        PageRequest pageable = PageRequest.of(0, 5);
        Page<CameraInfo> page = cameraInfoRepository.findAll(pageable);

        System.out.println("查询总页数" + page.getTotalPages());
        System.out.println("查询的总记录数" + page.getTotalElements());
        System.out.println("查询的当前第几页" + page.getNumber() + 1);
        System.out.println("查询的当前页面的集合" + page.getContent());
        System.out.println("查询的当前页面的记录数" + page.getNumberOfElements());
    }

    @Test
    public void testPageAndSort(){
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = Sort.by(order);

        //从0开区 取5条
        PageRequest pageable = PageRequest.of(0, 5, sort);
        Page<CameraInfo> page = cameraInfoRepository.findAll(pageable);

        System.out.println("查询总页数" + page.getTotalPages());
        System.out.println("查询的总记录数" + page.getTotalElements());
        System.out.println("查询的当前第几页" + page.getNumber() + 1);
        System.out.println("查询的当前页面的集合" + page.getContent());
        System.out.println("查询的当前页面的记录数" + page.getNumberOfElements());
    }
}