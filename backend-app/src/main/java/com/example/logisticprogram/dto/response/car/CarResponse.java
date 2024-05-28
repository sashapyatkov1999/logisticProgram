package com.example.logisticprogram.dto.response.car;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class CarResponse {
    private Long id;
    private String carNumber;
    private String trailerNumber;
    private LocalDateTime created;
    private LocalDateTime modified;
}
