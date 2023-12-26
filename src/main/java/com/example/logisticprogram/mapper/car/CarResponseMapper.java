package com.example.logisticprogram.mapper.car;

import com.example.logisticprogram.dto.response.car.CarResponse;
import com.example.logisticprogram.dto.response.driverstatus.DriverStatusResponse;
import com.example.logisticprogram.dto.response.typedoc.TypeDocResponse;
import com.example.logisticprogram.entity.Car;
import com.example.logisticprogram.entity.DriverStatus;
import com.example.logisticprogram.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarResponseMapper implements Mapper<CarResponse, Car> {
    @Override
    public CarResponse from(Car source) {
        return new CarResponse()
                .setId(source.getId())
                .setCarNumber(source.getCarNumber())
                .setTrailerNumber(source.getTrailerNumber())
                .setCreated(source.getCreated())
                .setModified(source.getModified());
    }
}
