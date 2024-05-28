package com.example.logisticprogram.mapper.role;

import com.example.logisticprogram.dto.request.role.RoleAddRequest;
import com.example.logisticprogram.entity.Role;
import com.example.logisticprogram.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleMapper implements Mapper<Role, RoleAddRequest> {
    @Override
    public Role from(RoleAddRequest source) {
        return new Role()
                .setName(source.getName())
                .setDescription(source.getDescription());
    }
}
