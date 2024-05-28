package com.example.logisticprogram.dto.request.userrole;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class UserRoleAddRequest {
    private Long userId;
    private Long roleId;
}
