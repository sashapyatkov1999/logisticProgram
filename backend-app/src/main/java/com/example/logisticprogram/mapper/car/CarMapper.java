package com.example.logisticprogram.mapper.car;

import com.example.logisticprogram.dto.request.car.CarAddRequest;
import com.example.logisticprogram.entity.Car;
import com.example.logisticprogram.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarMapper implements Mapper<Car, CarAddRequest> {
    @Override
    public Car from(CarAddRequest source) {
        return new Car()
                .setCarNumber(source.getCarNumber())
                .setTrailerNumber(source.getTrailerNumber());
    }
}
