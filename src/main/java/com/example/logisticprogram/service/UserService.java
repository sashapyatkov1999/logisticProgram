package com.example.logisticprogram.service;

import com.example.logisticprogram.dto.request.user.LoginRequest;
import com.example.logisticprogram.dto.request.user.UserAddRequest;
import com.example.logisticprogram.dto.request.user.UserRequest;
import com.example.logisticprogram.dto.response.user.UserResponse;
import com.example.logisticprogram.service.domain.UserDomainService;
import com.example.logisticprogram.service.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDomainService userDomainService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public UserResponse addUser(UserAddRequest request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));
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

    public String login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                       request.getLogin(),request.getPassword()
                )
        );

        var user = userDomainService.getUserByLogin(request.getLogin());
        return jwtService.generateToken(user);
    }
}




