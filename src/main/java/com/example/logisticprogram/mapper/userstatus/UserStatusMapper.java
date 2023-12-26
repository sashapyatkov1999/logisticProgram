package com.example.logisticprogram.mapper.userstatus;

import com.example.logisticprogram.dto.request.role.RoleAddRequest;
import com.example.logisticprogram.dto.request.userstatus.UserStatusAddRequest;
import com.example.logisticprogram.entity.Role;
import com.example.logisticprogram.entity.UserStatus;
import com.example.logisticprogram.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserStatusMapper implements Mapper<UserStatus, UserStatusAddRequest> {
    @Override
    public UserStatus from(UserStatusAddRequest source) {
        return new UserStatus()
                .setName(source.getName())
                .setDescription(source.getDescription());
    }
}
