package com.example.logisticprogram.dto.response.application_client;

import com.example.logisticprogram.dto.response.application.ApplicationResponse;
import com.example.logisticprogram.dto.response.user.UserResponse;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ApplicationClientResponse {
    private Long id;
    private ApplicationResponse application;
    private UserResponse client;
    private String description;
    private LocalDateTime created;
    private LocalDateTime modified;
}
