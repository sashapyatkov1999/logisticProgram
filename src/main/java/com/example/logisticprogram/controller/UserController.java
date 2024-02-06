package com.example.logisticprogram.controller;

import com.example.logisticprogram.dto.request.user.LoginRequest;
import com.example.logisticprogram.dto.request.user.UserAddRequest;
import com.example.logisticprogram.dto.request.user.UserRequest;
import com.example.logisticprogram.dto.response.user.UserResponse;
import com.example.logisticprogram.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    public static final String USER_ADD = "/api/v1/user/add";
    public static final String USER_GET = "/api/v1/user/get";
    public static final String USER_DELETE = "/api/v1/user/delete";
    public static final String USER_EDIT = "/api/v1/user/edit";
    public static final String USER_GET_ALL = "/api/v1/user/get-all";
    public static final String USER_SEARCH = "/api/v1/user/search";

    public static final String USER_LOGIN = "/api/v1/user/login";


    @PostMapping(
            value = USER_ADD,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public UserResponse addUser(@RequestBody UserAddRequest request) {
        return service.addUser(request);
    }
    @PostMapping(
            value = USER_GET,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public UserResponse getUser(@RequestBody UserRequest request) {
        return service.getUser(request);
    }

    @PostMapping(
            value = USER_LOGIN,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public Boolean login (@RequestBody LoginRequest request) {
        return service.login(request);
    }
    @PostMapping(
            value = USER_DELETE,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public void deleteUser(@RequestBody UserRequest request) {
        service.deleteUser(request);
    }

    @PostMapping(
            value = USER_EDIT,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public void editUser(@RequestBody UserAddRequest request) {
        service.editUser(request);
    }
    @PostMapping(
            value = USER_GET_ALL,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public List<UserResponse> getAllUsers() {
        return service.getAllUsers();
    }
    @PostMapping(
            value = USER_SEARCH,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public void search(@RequestBody String request) {
        service.search(request);
    }

}
