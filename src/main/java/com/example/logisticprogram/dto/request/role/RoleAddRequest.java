package com.example.logisticprogram.dto.request.role;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class RoleAddRequest {

    @Schema(description = "ID роли")
    private Long id;
    @Schema(description = "Имя роли")
    private String name;
    @Schema(description = "Описание роли")
    private String description;

}
