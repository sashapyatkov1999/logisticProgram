package com.example.logisticprogram.dto.response.driver;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class DriverResponse {
    private Long id;
    private String passportNumber;
    private String passportDate;
    private String registration;
    private String driverLicense;
    private LocalDateTime created;
    private LocalDateTime modified;
}
