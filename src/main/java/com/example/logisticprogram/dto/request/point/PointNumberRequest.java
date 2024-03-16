package com.example.logisticprogram.dto.request.point;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class PointNumberRequest {
    private Long id;
}
