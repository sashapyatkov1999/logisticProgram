package com.example.logisticprogram.dto.response.driverstatus;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class DriverStatusResponse {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime created;
    private LocalDateTime modified;
}
