package com.example.logisticprogram.dto.request.driverstatus;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class DriverStatusRequest {
    private Long id;
}
