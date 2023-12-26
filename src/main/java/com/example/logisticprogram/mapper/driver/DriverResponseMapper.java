package com.example.logisticprogram.mapper.driver;

import com.example.logisticprogram.dto.response.driver.DriverResponse;
import com.example.logisticprogram.entity.Driver;
import com.example.logisticprogram.mapper.Mapper;

public class DriverResponseMapper implements Mapper<DriverResponse, Driver> {
    @Override
    public DriverResponse from(Driver source) {
        return new DriverResponse()
                .setId(source.getId())
                .setPassportNumber(source.getPassportNumber())
                .setPassportDate(String.valueOf(source.getPassportDate()))
                .setRegistration(source.getPassportRegistration())
                .setDriverLicense(source.getDriverLicense())
                .setCreated(source.getCreated())
                .setModified(source.getModified());
    }
}
