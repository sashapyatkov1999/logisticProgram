package com.example.logisticprogram.controller;

import com.example.logisticprogram.dto.request.user.LoginRequest;
import com.example.logisticprogram.dto.request.user.UserAddRequest;
import com.example.logisticprogram.dto.response.user.UserResponse;
import com.example.logisticprogram.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;


    public static final String USER_SEARCH = "/api/v1/user/search";
    public static final String USER_LOGIN = "/api/v1/user/login";

    public static final String USER = "/api/v1/user/{id}";
    public static final String USERS = "/api/v1/user";

    public static final String WHO_I_AM = "/api/v1/user/who-i-am";


    @PostMapping(
            value = USERS,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public UserResponse addUser(@RequestBody UserAddRequest request) {
        return service.addUser(request);
    }

    @GetMapping(
            value = USER,
            produces = APPLICATION_JSON_VALUE)
    public UserResponse getUser(@PathVariable Long id) {
        return service.getUser(id);
    }


    @PostMapping(
            value = USER_LOGIN,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public String login (@RequestBody LoginRequest request) {
        return service.login(request);
    }


    @DeleteMapping(
            value = USER,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }

    @PutMapping(
            value = USER,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public void editUser(@PathVariable Long id, @RequestBody UserAddRequest request) {
        service.editUser(id, request);
    }
    @GetMapping(
            value = USERS,
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

    @GetMapping(
            value = WHO_I_AM,
            produces = APPLICATION_JSON_VALUE)
    public UserResponse whoIam(Authentication authentication) {
        return service.getCurrentUser(authentication);
    }

}
