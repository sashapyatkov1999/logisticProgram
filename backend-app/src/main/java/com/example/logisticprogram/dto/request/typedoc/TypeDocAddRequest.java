package com.example.logisticprogram.dto.request.typedoc;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class TypeDocAddRequest {
    private Long id;
    private String name;
    private String description;
}
