package com.example.logisticprogram.dto.response.userrole;

import com.example.logisticprogram.dto.response.role.RoleResponse;
import com.example.logisticprogram.dto.response.user.UserResponse;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class UserRoleResponse {
    private Long id;
    private UserResponse user;
    private RoleResponse role;
    private LocalDateTime created;
    private LocalDateTime modified;

}
