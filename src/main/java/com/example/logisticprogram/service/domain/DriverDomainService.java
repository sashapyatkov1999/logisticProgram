package com.example.logisticprogram.service.domain;


import com.example.logisticprogram.dto.request.driver.DriverAddRequest;
import com.example.logisticprogram.dto.request.driver.DriverFindByNameRequest;
import com.example.logisticprogram.dto.response.car.CarResponse;
import com.example.logisticprogram.dto.response.driver.DriverResponse;
import com.example.logisticprogram.mapper.car.CarResponseMapper;
import com.example.logisticprogram.mapper.driver.DriverMapper;
import com.example.logisticprogram.mapper.driver.DriverMerger;
import com.example.logisticprogram.mapper.driver.DriverResponseMapper;
import com.example.logisticprogram.mapper.user.UserResponseMapper;
import com.example.logisticprogram.repository.DriverRepository;
import com.example.logisticprogram.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverDomainService {
    private final DriverRepository driverRepository;
    private final DriverMapper driverMapper;
    private final DriverResponseMapper driverResponseMapper;
    private final DriverMerger driverMerger;
    private final CarResponseMapper carResponseMapper;

    @Transactional
    public DriverResponse getDriverById(Long id) {
        return driverResponseMapper
                .from(driverRepository.getReferenceById(id));
    }


    @Transactional
    public List<DriverResponse> getAllDrivers() {
        return driverResponseMapper.from(driverRepository.findAll());

    }

    @Transactional
    public void deleteDriver(Long id) {
        driverRepository.deleteById(id);
    }

    @Transactional
    public Long addDriver(DriverAddRequest request) {
        return driverRepository.save(driverMapper.from(request)).getId();

    }

    @Transactional

    public Long editDrivers(DriverAddRequest request){
        var driver = repository.getReferenceById(request.getId());
         return repository.saveAndFlush
                 (driverMerger.merge(driver,request))
                 .getId();

    }
}
