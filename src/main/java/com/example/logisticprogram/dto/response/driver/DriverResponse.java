package com.example.logisticprogram.dto.response.driver;

import com.example.logisticprogram.dto.response.car.CarResponse;
import com.example.logisticprogram.dto.response.driverstatus.DriverStatusResponse;
import com.example.logisticprogram.dto.response.user.UserResponse;
import com.example.logisticprogram.entity.Car;
import com.example.logisticprogram.entity.DriverStatus;
import com.example.logisticprogram.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class DriverResponse {
    private Long id;
    private UserResponse user;
    private DriverStatusResponse driverStatus;
    private CarResponse car;
    private String passportNumber;
    private String passportDate;
    private String registration;
    private String driverLicense;
    private LocalDateTime created;
    private LocalDateTime modified;
}
