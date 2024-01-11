package com.example.logisticprogram.dto.response.application;

import com.example.logisticprogram.dto.response.driver.DriverResponse;
import com.example.logisticprogram.dto.response.user.UserResponse;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ApplicationResponse {
    private Long id;
    private String name;
    private String description;
    private UserResponse manager;
    private DriverResponse driver;
    private LocalDateTime created;
    private LocalDateTime modified;
}
