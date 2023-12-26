package com.example.logisticprogram.dto.response.file;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class FileResponse {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime created;
    private LocalDateTime modified;
}
