package com.example.logisticprogram.controller;

import com.example.logisticprogram.dto.request.typedoc.TypeDocNumberRequest;
import com.example.logisticprogram.dto.request.user.UserAddRequest;
import com.example.logisticprogram.dto.request.user.UserRequest;
import com.example.logisticprogram.dto.response.typedoc.TypeDocResponse;
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
    public static final String USER_SET_LOGIN = "/api/v1/user/set-login";
    public static final String USER_SET_PASSWORD = "/api/v1/user/set-password";
    public static final String USER_ADD = "/api/v1/user/add";
    public static final String USER_GET = "/api/v1/user/get";
    public static final String USER_DELETE = "/api/v1/user/delete";
    public static final String USER_GET_LOGIN = "/api/v1/user/get-login";
    public static final String USER_GET_PASSWORD = "/api/v1/user/get-password";
    public static final String USER_GET_REGISTRATION = "/api/v1/user/get-registration";
    public static final String USER_SET_REGISTRATION = "/api/v1/user/set-registration";
    public static final String USER_EDIT = "/api/v1/user/edit";
    public static final String USER_GET_ALL = "/api/v1/user/get-all";
    public static final String USER_SEARCH = "/api/v1/user/search";
    @PostMapping(
            value = USER_SET_LOGIN,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public void setLogin(@RequestBody String request) {
        service.setLogin(request);
    }

    @PostMapping(
            value = USER_SET_PASSWORD,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public void setPassword(@RequestBody String request) {
        service.setPassword(request);
    }
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
            value = USER_DELETE,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public void deleteUser(@RequestBody UserRequest request) {
        service.deleteUser(request);
    }
    @PostMapping(
            value = USER_GET_LOGIN,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public String getLogin(@RequestBody UserRequest request) {
        return service.getLogin(request);
    }
    @PostMapping(
            value = USER_GET_PASSWORD,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public String getPassword(@RequestBody UserRequest request) {
        return service.getPassword(request);
    }
    @PostMapping(
            value = USER_GET_REGISTRATION,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public String getRegistration(@RequestBody UserRequest request) {
        return service.getRegistration(request);
    }
    @PostMapping(
            value = USER_SET_REGISTRATION,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public void setRegistration(@RequestBody String registration, @RequestBody UserRequest request) {
        service.setRegistration(registration, request);
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
    public void search(@RequestBody List<UserResponse> userResponses,@RequestBody char request) {
        service.search(userResponses,request);
    }

}
