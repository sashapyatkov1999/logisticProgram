package com.example.logisticprogram.mapper.role;

import com.example.logisticprogram.dto.response.role.RoleResponse;
import com.example.logisticprogram.entity.Role;
import com.example.logisticprogram.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleResponseMapper implements Mapper<RoleResponse, Role> {
    @Override
    public RoleResponse from(Role source) {
        return new RoleResponse()
                .setId(source.getId())
                .setName(source.getName())
                .setDescription(source.getDescription())
                .setCreated(source.getCreated())
                .setModified(source.getModified());
    }
}
