package com.example.logisticprogram.dto.request.userstatus;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class UserStatusAddRequest {
    private String name;
    private String description;
}
