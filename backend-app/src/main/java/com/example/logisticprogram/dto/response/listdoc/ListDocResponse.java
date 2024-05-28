package com.example.logisticprogram.dto.response.listdoc;

import com.example.logisticprogram.dto.response.application.ApplicationResponse;
import com.example.logisticprogram.dto.response.point.PointResponse;
import com.example.logisticprogram.dto.response.typedoc.TypeDocResponse;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ListDocResponse {
    private Long id;
    private PointResponse point;
    private ApplicationResponse application;
    private TypeDocResponse typeDoc;
    private LocalDateTime created;
    private LocalDateTime modified;
}
