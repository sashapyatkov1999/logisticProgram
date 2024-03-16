package com.example.logisticprogram.controller;



import com.example.logisticprogram.dto.request.role.RoleAddRequest;
import com.example.logisticprogram.dto.request.role.RoleRequest;
import com.example.logisticprogram.dto.response.role.RoleResponse;
import com.example.logisticprogram.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequiredArgsConstructor
@Tag(name = "Управление ролями")
public class RoleController {

    private final RoleService service;


    public static final String ROLE_ADD = "/api/v1/role/add";
    public static final String ROLE_GET = "/api/v1/role/get";
    public static final String ROLE_DELETE = "/api/v1/role/delete";


    @Operation(description = "Добавление новой роли", summary = "Добавление новой роли")
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
