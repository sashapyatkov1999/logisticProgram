package com.example.logisticprogram.dto.request.driver;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class DriverAddRequest {
    private Long id;
    private Long userId;
    private Long driverStatusId;
    private Long carId;
    private String passportNumber;
    private String passportDate;
    private String registration;
    private String driverLicense;


}
