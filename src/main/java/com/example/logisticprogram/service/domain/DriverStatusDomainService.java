package com.example.logisticprogram.service.domain;

import com.example.logisticprogram.dto.response.driverstatus.DriverStatusResponse;
import com.example.logisticprogram.mapper.driverstatus.DriverStatusMapper;
import com.example.logisticprogram.mapper.driverstatus.DriverStatusResponseMapper;
import com.example.logisticprogram.repository.DriverStatusRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverStatusDomainService {
    private final DriverStatusRepository driverStatusRepository;
    private final DriverStatusMapper driverStatusMapper;
    private final DriverStatusResponseMapper driverStatusResponseMapper;

    @Transactional
    public DriverStatusResponse getDriverStatusById(Long id) {
        return driverStatusResponseMapper.from(driverStatusRepository.getReferenceById(id));
    }


    @Transactional
    public List<DriverStatusResponse> getAllDriverStatus() {
        return driverStatusResponseMapper.from(driverStatusRepository.findAll());

    }

}
