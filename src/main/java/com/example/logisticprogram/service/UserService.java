package com.example.logisticprogram.service;

import com.example.logisticprogram.dto.request.user.LoginRequest;
import com.example.logisticprogram.dto.request.user.UserAddRequest;
import com.example.logisticprogram.dto.request.user.UserRequest;
import com.example.logisticprogram.dto.response.user.UserResponse;
import com.example.logisticprogram.service.domain.UserDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDomainService userDomainService;

    public UserResponse addUser(UserAddRequest request) {
        var id = userDomainService.addUser(request);
        return userDomainService.getUser(id);
    }


    public UserResponse getUser(UserRequest request) {
        return userDomainService.getUser(request.getId());
    }

    public void deleteUser(UserRequest request) {
        userDomainService.deleteUser(request.getId());
    }

    public void editUser(UserAddRequest request) {
        userDomainService.editUser(request);
    }

    public List<UserResponse> getAllUsers() {
        return userDomainService.getAllUsers();
    }

    public List<UserResponse> search(String searchValue) {

        return userDomainService.getAllUsers().stream()
                .filter(userResponse ->
                        userResponse.getName().toLowerCase().contains(searchValue) ||
                                userResponse.getSurname().toLowerCase().contains(searchValue) ||
                                userResponse.getEMail().toLowerCase().contains(searchValue) ||
                                userResponse.getPhoneNumber().toLowerCase().contains(searchValue))
                .toList();
    }

    public Boolean login(LoginRequest request) {
        return userDomainService.login(request);
    }
}




