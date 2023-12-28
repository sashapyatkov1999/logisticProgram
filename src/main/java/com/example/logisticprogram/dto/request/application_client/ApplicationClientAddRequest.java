package com.example.logisticprogram.dto.request.application_client;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ApplicationClientAddRequest {
    private Long applicationId;
    private Long clientId;
    private String description;

}
