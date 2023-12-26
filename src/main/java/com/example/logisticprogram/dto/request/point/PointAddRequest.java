package com.example.logisticprogram.dto.request.point;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class PointAddRequest {

    private String field;
    private Integer ordinal;
    private Boolean statusOfOrdinalWithGeo;
    private String name;
    private String description;
    private Date timeStart;
    private Date timeEnd;

}
