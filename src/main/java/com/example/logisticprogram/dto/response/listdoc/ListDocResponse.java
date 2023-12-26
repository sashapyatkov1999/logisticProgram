package com.example.logisticprogram.dto.response.listdoc;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ListDocResponse {
    private Long id;
    private LocalDateTime created;
    private LocalDateTime modified;
}
