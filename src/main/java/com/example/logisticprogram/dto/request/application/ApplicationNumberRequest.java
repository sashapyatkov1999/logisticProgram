package com.example.logisticprogram.dto.request.application;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ApplicationNumberRequest {
    private Long id;
}
