package com.example.logisticprogram.service;

import com.example.logisticprogram.dto.request.user.UserAddRequest;
import com.example.logisticprogram.dto.request.user.UserRequest;
import com.example.logisticprogram.dto.response.driver.DriverResponse;
import com.example.logisticprogram.dto.response.user.UserResponse;
import com.example.logisticprogram.entity.User;
import com.example.logisticprogram.mapper.user.UserResponseMapper;
import com.example.logisticprogram.repository.UserRepository;
import com.example.logisticprogram.service.domain.UserDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDomainService userDomainService;
    private final UserRepository userRepository;
    private DriverResponse driverResponse;
    private UserResponse userResponse;
    private UserAddRequest userAddRequest;
    private User user;
    private UserResponseMapper userResponseMapper;
    private List<DriverResponse> driverList;

    public void setLogin(String login){
        userResponse.setLogin(login);
    }

    public void setPassword(String password){
        userResponse.setPassword(password);
    }

    public UserResponse addUser(UserAddRequest request){
        var id = userDomainService.addUser(request);
        return userDomainService.getUser(id);
    }


    public UserResponse getUser(UserRequest request){
        return  userDomainService.getUser(request.getId());
    }

    public void deleteUser(UserRequest request){
        userDomainService.deleteUser(request.getId());
    }



    public String getLogin(UserRequest request){
        return getUser(request).getLogin();
    }

    public String getPassword(UserRequest request){
        return getUser(request).getPassword();
    }
    public String getRegistration(UserRequest request){
        Long id = getUser(request).getId();

        if (driverList.contains(id)){
            int index = driverList.indexOf(id);
            driverResponse = driverList.get(index);
            return driverResponse.getRegistration();
        } else throw new IllegalArgumentException("Проверьте id пользавателя, может быть это не id водителя");
    }
    public void setRegistration(String registration, UserRequest request){

        Long id = getUser(request).getId();

        if (driverList.contains(id)){
            int index = driverList.indexOf(id);
            driverResponse = driverList.get(index);
            driverResponse.setRegistration(registration);
        } else throw new IllegalArgumentException("Проверьте id пользавателя, может быть это не id водителя");
    }

    public void editUser(UserAddRequest request) {
        userDomainService.editUser(request);
    }
    public List<UserResponse> getAllUsers() {
        return userDomainService.getAllUsers();
    }
    public List<UserResponse> search(List<UserResponse> userResponses, char request) {
        return userResponses.stream()
                .filter(userResponse ->
                        userResponse.getName().toLowerCase().contains(String.valueOf(Character.toLowerCase(request))) ||
                                userResponse.getSurname().toLowerCase().contains(String.valueOf(Character.toLowerCase(request))) ||
                                userResponse.getEMail().toLowerCase().contains(String.valueOf(Character.toLowerCase(request))) ||
                                userResponse.getPhoneNumber().toLowerCase().contains(String.valueOf(Character.toLowerCase(request))))
                .collect(Collectors.toList());
    }

}




