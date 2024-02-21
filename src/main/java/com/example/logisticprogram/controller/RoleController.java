package com.example.logisticprogram.controller;



import com.example.logisticprogram.dto.request.role.RoleAddRequest;
import com.example.logisticprogram.dto.request.role.RoleRequest;
import com.example.logisticprogram.dto.response.role.RoleResponse;
import com.example.logisticprogram.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequiredArgsConstructor
public class RoleController {

    private final RoleService service;


    public static final String ROLE_ADD = "/api/v1/role/add";
    public static final String ROLE_GET = "/api/v1/role/get";
    public static final String ROLE_DELETE = "/api/v1/role/delete";
    private static final String ROLE_GET_ALL = "/api/v1/role/get-all";
    private static final String ROLE_EDIT = "/api/v1/role/edit";




    @PostMapping(
            value = ROLE_ADD,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public RoleResponse addRole(@RequestBody RoleAddRequest request){
        return service.addRole(request);
    }


    @PostMapping(
            value = ROLE_GET,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public RoleResponse getRole(@RequestBody RoleRequest request){
        return service.getRole(request);
    }


    @PostMapping(
            value = ROLE_GET_ALL,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public List<RoleResponse> getAllRoles(){
        return service.getAllRoles();
    }
    @PostMapping(
            value = ROLE_EDIT,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public void editRole(RoleAddRequest request){
        service.editRole(request);
    }

    @PostMapping(
            value = ROLE_DELETE,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public String deleteRole(@RequestBody RoleRequest request){

        try {
            service.deleteRole(request);
            return "Роль успешно удалена";
        }catch (Exception ex){
            return "При удалении роли произошла ошибка: " + ex.getMessage();
        }
    }


}
