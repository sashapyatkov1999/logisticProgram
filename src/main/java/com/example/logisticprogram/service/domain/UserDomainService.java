package com.example.logisticprogram.service.domain;

import com.example.logisticprogram.dto.request.user.LoginRequest;
import com.example.logisticprogram.dto.request.user.UserAddRequest;
import com.example.logisticprogram.dto.response.user.UserResponse;
import com.example.logisticprogram.mapper.user.UserMapper;
import com.example.logisticprogram.mapper.user.UserMerger;
import com.example.logisticprogram.mapper.user.UserResponseMapper;
import com.example.logisticprogram.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDomainService {
    private final UserRepository userRepository;
    private final UserResponseMapper userResponseMapper;
    private final UserMapper userMapper;
    private final UserMerger userMerger;

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
    public Long editUser(UserAddRequest request) {
        var user = userRepository.getReferenceById(request.getUserId());
        return userRepository.save(userMerger.merge(user, request)).getId();
    }
}
