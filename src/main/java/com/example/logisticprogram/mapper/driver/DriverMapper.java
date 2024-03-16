package com.example.logisticprogram.mapper.driver;

import com.example.logisticprogram.dto.request.driver.DriverAddRequest;
import com.example.logisticprogram.dto.response.driver.DriverResponse;
import com.example.logisticprogram.entity.Car;
import com.example.logisticprogram.entity.Driver;
import com.example.logisticprogram.entity.DriverStatus;
import com.example.logisticprogram.entity.DriverStatusEnum;
import com.example.logisticprogram.entity.User;
import com.example.logisticprogram.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class DriverMapper  implements Mapper<Driver, DriverAddRequest> {
    @Override
    public Driver from(DriverAddRequest source) {
        return new Driver()
                .setUser(new User(source.getUserId()))
                .setDriverStatus(new DriverStatus(DriverStatusEnum.WAIT_DOCS.getId()))
                .setCar(new Car(source.getCarId()))
                .setPassportNumber(source.getPassportNumber())
                .setPassportDate(LocalDate.parse(source.getPassportDate()))
                .setPassportRegistration(source.getRegistration())
                .setDriverLicense(source.getDriverLicense());

    }
}
