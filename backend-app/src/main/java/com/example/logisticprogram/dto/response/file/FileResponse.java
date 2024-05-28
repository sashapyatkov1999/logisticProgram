package com.example.logisticprogram.dto.response.file;

import com.example.logisticprogram.dto.response.application.ApplicationResponse;
import com.example.logisticprogram.dto.response.point.PointResponse;
import com.example.logisticprogram.dto.response.user.UserResponse;
import com.example.logisticprogram.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class FileResponse {
    private Long id;
    private PointResponse point;
    private UserResponse user;
    private ApplicationResponse application;
    private String name;
    private String description;
    private LocalDateTime created;
    private LocalDateTime modified;
}
