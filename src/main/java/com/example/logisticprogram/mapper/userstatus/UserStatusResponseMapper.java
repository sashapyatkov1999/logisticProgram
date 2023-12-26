package com.example.logisticprogram.mapper.userstatus;

import com.example.logisticprogram.dto.response.userstatus.UserStatusResponse;
import com.example.logisticprogram.entity.UserStatus;
import com.example.logisticprogram.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserStatusResponseMapper implements Mapper<UserStatusResponse, UserStatus> {
    @Override
    public UserStatusResponse from(UserStatus source) {
        return new UserStatusResponse()
                .setId(source.getId())
                .setName(source.getName())
                .setDescription(source.getDescription())
                .setCreated(source.getCreated())
                .setModified(source.getModified());
    }
}
