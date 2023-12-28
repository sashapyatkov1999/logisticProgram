package com.example.logisticprogram.mapper.userrole;

import com.example.logisticprogram.dto.request.application.ApplicationAddRequest;
import com.example.logisticprogram.dto.request.userrole.UserRoleAddRequest;
import com.example.logisticprogram.entity.Application;
import com.example.logisticprogram.entity.Role;
import com.example.logisticprogram.entity.User;
import com.example.logisticprogram.entity.UserRole;
import com.example.logisticprogram.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRoleMapper implements Mapper<UserRole, UserRoleAddRequest> {
    @Override
    public UserRole from(UserRoleAddRequest source) {
        return new UserRole()
                .setUser(new User(source.getUserId()))
                .setRole(new Role(source.getRoleId()));
    }
}
