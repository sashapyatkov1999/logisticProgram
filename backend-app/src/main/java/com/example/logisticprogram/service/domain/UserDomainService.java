package com.example.logisticprogram.service.domain;

import com.example.logisticprogram.dto.request.user.LoginRequest;
import com.example.logisticprogram.dto.request.user.UserAddRequest;
import com.example.logisticprogram.dto.response.user.UserResponse;
import com.example.logisticprogram.dto.response.userrole.UserRoleResponse;
import com.example.logisticprogram.entity.User;
import com.example.logisticprogram.mapper.user.UserMapper;
import com.example.logisticprogram.mapper.user.UserMerger;
import com.example.logisticprogram.mapper.user.UserResponseMapper;
import com.example.logisticprogram.mapper.userrole.UserRoleResponseMapper;
import com.example.logisticprogram.repository.UserRepository;
import com.example.logisticprogram.repository.UserRoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDomainService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final UserResponseMapper userResponseMapper;
    private final UserMapper userMapper;
    private final UserMerger userMerger;
    private final UserRoleResponseMapper userRoleResponseMapper;

    @Transactional
    public UserResponse getUser(Long id) {
        return userResponseMapper
                .from(userRepository.getReferenceById(id));
    }

    @Transactional
    public List<UserResponse> getAllUsers() {
        return userResponseMapper.from(userRepository.findAll());

    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public Long addUser(UserAddRequest request) {
        return userRepository.save(userMapper.from(request)).getId();
    }
    
    @Transactional
    public Boolean login(LoginRequest request) {
        return userRepository
                .findByLogin(request.getLogin())
                .map(value -> value.getPassword().equals(request.getPassword()))
                .orElse(false);
    }
    @Transactional
    public Long editUser(Long userId, UserAddRequest request) {
        var user = userRepository.getReferenceById(userId);
        return userRepository.save(userMerger.merge(user, request)).getId();
    }

    @Transactional
    public User getUserByLogin(String login) {
       return userRepository.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден!"));
    }

    @Transactional
    public UserResponse getUserResponseByLogin(String login) {
        return userResponseMapper.from(getUserByLogin(login));
    }

    @Transactional
    public List<UserRoleResponse> getUserRoles(String login){
        var user = userRepository.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден!"));
        return userRoleResponseMapper.from(userRoleRepository.findByUserId(user.getId()));
    }

    public UserDetailsService userDetailsService(){
        return this::getUserByLogin;
    }

}
