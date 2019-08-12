package com.fangle.parking.repository;

import com.fangle.parking.entity.CameraInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CameraInfoRepository extends JpaRepository<CameraInfo, Long> {

}
