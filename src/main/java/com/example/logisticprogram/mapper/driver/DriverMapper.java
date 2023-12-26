package com.example.logisticprogram.mapper.driver;

import com.example.logisticprogram.dto.request.driver.DriverAddRequest;
import com.example.logisticprogram.entity.Driver;
import com.example.logisticprogram.mapper.Mapper;

public class DriverMapper  implements Mapper<Driver, DriverAddRequest> {
    @Override
    public Driver from(DriverAddRequest source) {
        return null;
    }
}
