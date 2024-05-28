package com.example.logisticprogram.dto.response.point;

import com.example.logisticprogram.dto.response.application.ApplicationResponse;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class PointResponse {
    private Long id;
    private String field;
    private Integer ordinal;
    private ApplicationResponse application;
    private Boolean statusOfOrdinalWithGeo;
    private String name;
    private String description;
    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;

}
