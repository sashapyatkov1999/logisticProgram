package com.example.logisticprogram.dto.request.file;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class FileAddRequest {
    private Long pointId;
    private Long applicationId;
    private Long userId;
    private String name;
    private String description;
}
