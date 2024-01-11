package com.example.logisticprogram.dto.request.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class UserAddRequest {
    private Long userStatusId;
    private String name;
    private String surname;
    private String eMail;
    private String phoneNumber;
}
