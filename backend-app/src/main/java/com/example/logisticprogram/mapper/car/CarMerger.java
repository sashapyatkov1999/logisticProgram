package com.example.logisticprogram.mapper.car;

import com.example.logisticprogram.dto.request.car.CarAddRequest;
import com.example.logisticprogram.entity.Car;
import com.example.logisticprogram.mapper.Merger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarMerger implements Merger<Car, CarAddRequest> {
    @Override
    public Car merge(Car target, CarAddRequest source) {
        return target
                .setCarNumber(source.getCarNumber())
                .setTrailerNumber(source.getTrailerNumber());
    }
}
