package com.example.logisticprogram.dto.response.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String eMail;
    private String phoneNumber;
    private LocalDateTime created;
    private LocalDateTime modified;

}
