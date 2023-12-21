package com.example.logisticprogram.dto.request.role;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class RoleAddRequest {

    private String name;
    private String description;

}
