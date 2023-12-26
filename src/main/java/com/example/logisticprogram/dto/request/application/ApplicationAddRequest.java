package com.example.logisticprogram.dto.request.application;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ApplicationAddRequest {
    private String name;
    private String description;

}
