package com.example.logisticprogram.repository;

import com.example.logisticprogram.entity.DriverStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverStatusRepository extends JpaRepository<DriverStatus, Long> {
}
