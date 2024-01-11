package com.example.logisticprogram.mapper.user;

import com.example.logisticprogram.dto.request.role.RoleAddRequest;
import com.example.logisticprogram.dto.request.user.UserAddRequest;
import com.example.logisticprogram.dto.response.user.UserResponse;
import com.example.logisticprogram.entity.Role;
import com.example.logisticprogram.entity.User;
import com.example.logisticprogram.entity.UserStatus;
import com.example.logisticprogram.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMapper implements Mapper<User, UserAddRequest> {
    @Override
    public User from(UserAddRequest source) {
        return new User()
                .setStatus(new UserStatus(source.getUserStatusId()))
                .setName(source.getName())
                .setSurname(source.getSurname())
                .setPhoneNumber(Long.valueOf(source.getPhoneNumber()));
    }
}
