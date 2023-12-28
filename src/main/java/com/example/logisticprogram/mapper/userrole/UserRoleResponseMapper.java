package com.example.logisticprogram.mapper.userrole;

import com.example.logisticprogram.dto.response.userrole.UserRoleResponse;
import com.example.logisticprogram.entity.UserRole;
import com.example.logisticprogram.mapper.Mapper;
import com.example.logisticprogram.mapper.role.RoleResponseMapper;
import com.example.logisticprogram.mapper.user.UserResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRoleResponseMapper implements Mapper<UserRoleResponse, UserRole> {
    private final UserResponseMapper userResponseMapper;
    private final RoleResponseMapper roleResponseMapper;
    @Override
    public UserRoleResponse from(UserRole source) {
        return new UserRoleResponse()
                .setUser(userResponseMapper.from(source.getUser()))
                .setRole(roleResponseMapper.from(source.getRole()))
                .setCreated(source.getCreated())
                .setModified(source.getModified());
    }
}
