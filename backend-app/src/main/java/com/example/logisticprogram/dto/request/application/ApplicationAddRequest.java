package com.example.logisticprogram.dto.request.application;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

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
