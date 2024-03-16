package com.example.logisticprogram.dto.request.application;

import com.example.logisticprogram.dto.response.driver.DriverResponse;
import com.example.logisticprogram.dto.response.user.UserResponse;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ApplicationAddRequest {
    private Long id;
    private Long managerId;
    private Long driverId;
    private String name;
    private String description;


}
