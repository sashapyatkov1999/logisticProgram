package com.example.logisticprogram.dto.request.car;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class CarAddRequest {
    private Long id;
    private String carNumber;
    private String trailerNumber;


}
