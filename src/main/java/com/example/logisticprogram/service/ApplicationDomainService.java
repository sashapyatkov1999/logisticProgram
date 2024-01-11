package com.example.logisticprogram.service;

import com.example.logisticprogram.dto.request.application.ApplicationAddRequest;
import com.example.logisticprogram.dto.request.userstatus.UserStatusAddRequest;
import com.example.logisticprogram.dto.response.application.ApplicationResponse;
import com.example.logisticprogram.dto.response.userstatus.UserStatusResponse;
import com.example.logisticprogram.mapper.application.ApplicationMapper;
import com.example.logisticprogram.mapper.application.ApplicationResponseMapper;
import com.example.logisticprogram.repository.ApplicationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationDomainService {
    private final ApplicationRepository applicationRepository;
    private final ApplicationMapper applicationMapper;
    private final ApplicationResponseMapper applicationResponseMapper;
    @Transactional
    public ApplicationResponse getApplication(Long id) {
        return applicationResponseMapper.from(applicationRepository.getReferenceById(id));
    }

    @Transactional
    public List<ApplicationResponse> getAllApplications() {
        return applicationResponseMapper.from(applicationRepository.findAll());

    }

    @Transactional
    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }

    @Transactional
    public Long addApplication(ApplicationAddRequest request) {
        return applicationRepository.save(applicationMapper.from(request)).getId();

    }
}
