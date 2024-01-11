package com.example.logisticprogram.mapper.driver;

import com.example.logisticprogram.dto.response.driver.DriverResponse;
import com.example.logisticprogram.entity.Driver;
import com.example.logisticprogram.mapper.Mapper;
import com.example.logisticprogram.mapper.car.CarResponseMapper;
import com.example.logisticprogram.mapper.driverstatus.DriverStatusResponseMapper;
import com.example.logisticprogram.mapper.user.UserResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverResponseMapper implements Mapper<DriverResponse, Driver> {
    UserResponseMapper userResponseMapper;
    DriverStatusResponseMapper driverStatusResponseMapper;
    CarResponseMapper carResponseMapper;
    @Override
    public DriverResponse from(Driver source) {
        return new DriverResponse()
                .setId(source.getId())
                .setUser(userResponseMapper.from(source.getUser()))
                .setDriverStatus(driverStatusResponseMapper.from(source.getDriverStatus()))
                .setCar(carResponseMapper.from(source.getCar()))
                .setPassportNumber(source.getPassportNumber())
                .setPassportDate(String.valueOf(source.getPassportDate()))
                .setRegistration(source.getPassportRegistration())
                .setDriverLicense(source.getDriverLicense())
                .setCreated(source.getCreated())
                .setModified(source.getModified());
    }
}
