package com.example.logisticprogram.dto.request.listdoc;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ListDocRequest {
    private Long id;
}
