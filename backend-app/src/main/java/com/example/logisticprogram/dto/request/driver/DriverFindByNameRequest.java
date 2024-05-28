package com.example.logisticprogram.dto.request.driver;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class DriverFindByNameRequest {
    private String findByName;
}
