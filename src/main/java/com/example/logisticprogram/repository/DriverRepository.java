package com.example.logisticprogram.repository;

import com.example.logisticprogram.entity.Driver;
import com.example.logisticprogram.entity.DriverStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

}
