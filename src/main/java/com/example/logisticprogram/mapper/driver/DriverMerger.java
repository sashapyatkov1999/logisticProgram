package com.example.logisticprogram.mapper.driver;

import com.example.logisticprogram.dto.request.driver.DriverAddRequest;
import com.example.logisticprogram.entity.Car;
import com.example.logisticprogram.entity.Driver;
import com.example.logisticprogram.entity.DriverStatus;
import com.example.logisticprogram.entity.User;
import com.example.logisticprogram.mapper.Merger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class DriverMerger implements Merger<Driver, DriverAddRequest> {
    @Override
    public Driver merge(Driver target, DriverAddRequest source) {
        return target
                .setPassportNumber(source.getPassportNumber())
                .setPassportDate(LocalDate.parse(source.getPassportDate()))
                .setPassportRegistration(source.getRegistration())
                .setUser(new User(source.getUserId()))
                .setDriverStatus(new DriverStatus(source.getDriverStatusId()))
                .setCar(new Car(source.getCarId()))
                .setDriverLicense(source.getDriverLicense());
    }
}
