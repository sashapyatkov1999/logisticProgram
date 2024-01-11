package com.example.logisticprogram.dto.request.listdoc;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ListDocAddRequest {
    private Long pointId;
    private Long applicationId;
    private Long typeDocId;
}

