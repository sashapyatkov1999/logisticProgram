package com.example.logisticprogram.dto.response.driver;

import com.example.logisticprogram.dto.response.car.CarResponse;
import com.example.logisticprogram.dto.response.user.UserResponse;
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
    private String driverStatus;
    private CarResponse car;
    private String passportNumber;
    private String passportDate;
    private String registration;
    private String driverLicense;
    private LocalDateTime created;
    private LocalDateTime modified;
}
