package com.example.logisticprogram.service.domain;

import com.example.logisticprogram.dto.request.role.RoleAddRequest;
import com.example.logisticprogram.dto.response.role.RoleResponse;
import com.example.logisticprogram.mapper.role.RoleMapper;
import com.example.logisticprogram.mapper.role.RoleMerger;
import com.example.logisticprogram.mapper.role.RoleResponseMapper;
import com.example.logisticprogram.repository.RoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleDomainService {

    private final RoleRepository repository;
    private final RoleResponseMapper roleResponseMapper;
    private final RoleMapper roleMapper;
    private final RoleMerger roleMerger;

    public RoleResponse getRole(Long id) {
        return roleResponseMapper.from(repository.findById(id).orElseThrow(() -> new RuntimeException("Роль не найдена!")));
    }


    @Transactional
    public List<RoleResponse> getAllRoles() {
        return roleResponseMapper.from(repository.findAll());

    }

    @Transactional
    public void deleteRole(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public Long addRole(RoleAddRequest request) {
        return repository.save(roleMapper.from(request)).getId();
    }


    @Transactional
    public Long editRole(RoleAddRequest request) {
        var role = repository.getReferenceById(request.getId());
        return repository.save(roleMerger.merge(role, request)).getId();

    }

}
