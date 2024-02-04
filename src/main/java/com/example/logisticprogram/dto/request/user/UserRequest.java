package com.example.logisticprogram.dto.request.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class UserRequest {
    private Long id;
}
