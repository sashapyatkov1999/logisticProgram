package com.example.logisticprogram.mapper.user;

import com.example.logisticprogram.dto.response.user.UserResponse;
import com.example.logisticprogram.entity.User;
import com.example.logisticprogram.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserResponseMapper implements Mapper<UserResponse, User> {
    @Override
    public UserResponse from(User source) {
        return new UserResponse()
                .setId(source.getId())
                .setUserStatus(source.getStatus().getName())
                .setLogin(source.getLogin())
                .setPassword(source.getPassword())
                .setName(source.getName())
                .setSurname(source.getSurname())
                .setEMail(source.getEmail())
                .setPhoneNumber(source.getPhoneNumber())
                .setCreated(source.getCreated())
                .setModified(source.getModified());
    }
}
