package com.example.logisticprogram.mapper.role;

import com.example.logisticprogram.dto.request.role.RoleAddRequest;
import com.example.logisticprogram.entity.Role;
import com.example.logisticprogram.mapper.Merger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleMerger implements Merger<Role, RoleAddRequest> {
    @Override
    public Role merge(Role target, RoleAddRequest source) {
        return target
                .setName(source.getName())
                .setDescription(source.getDescription());
    }
}
