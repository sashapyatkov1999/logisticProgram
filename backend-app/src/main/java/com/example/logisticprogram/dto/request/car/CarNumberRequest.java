package com.example.logisticprogram.dto.request.car;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class CarNumberRequest {
    private String number;
}
