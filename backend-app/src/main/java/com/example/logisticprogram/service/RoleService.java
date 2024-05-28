package com.example.logisticprogram.service;

import com.example.logisticprogram.dto.request.role.RoleAddRequest;
import com.example.logisticprogram.dto.request.role.RoleRequest;
import com.example.logisticprogram.dto.request.user.UserAddRequest;
import com.example.logisticprogram.dto.response.role.RoleResponse;

import com.example.logisticprogram.service.domain.RoleDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleDomainService roleDomainService;

    public RoleResponse addRole(RoleAddRequest request){
        var id = roleDomainService.addRole(request);
        return  roleDomainService.getRole(id);
    }
    public List<RoleResponse> getAllRoles(){
        return roleDomainService.getAllRoles();
    }

    public RoleResponse getRole(RoleRequest request) {
        return  roleDomainService.getRole(request.getId());
    }

    public void deleteRole(RoleRequest request) {
          roleDomainService.deleteRole(request.getId());
    }
    public void editRole(RoleAddRequest request) {
        roleDomainService.editRole(request);
    }



}
