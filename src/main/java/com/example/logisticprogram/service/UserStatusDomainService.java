package com.example.logisticprogram.service;

import com.example.logisticprogram.dto.request.userstatus.UserStatusAddRequest;
import com.example.logisticprogram.dto.response.userstatus.UserStatusResponse;
import com.example.logisticprogram.mapper.userstatus.UserStatusMapper;
import com.example.logisticprogram.mapper.userstatus.UserStatusResponseMapper;
import com.example.logisticprogram.repository.UserStatusRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserStatusDomainService {
    private final UserStatusRepository userStatusRepository;
    private final UserStatusResponseMapper userStatusResponseMapper;
    private final UserStatusMapper userStatusMapper;

    @Transactional
    public UserStatusResponse getUserStatus(Long id) {
        return userStatusResponseMapper.from(userStatusRepository.getReferenceById(id));
    }


    @Transactional
    public List<UserStatusResponse> getAllUserStatus() {
        return userStatusResponseMapper.from(userStatusRepository.findAll());

    }

    @Transactional
    public void deleteUserStatus(Long id) {
        userStatusRepository.deleteById(id);
    }

    @Transactional
    public Long addUserStatus(UserStatusAddRequest request) {
        return userStatusRepository.save(userStatusMapper.from(request)).getId();

    }


}
