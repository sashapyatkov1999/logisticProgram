package com.example.logisticprogram.service.domain;

import com.example.logisticprogram.dto.request.application.ApplicationAddRequest;
import com.example.logisticprogram.dto.request.listdoc.ListDocAddRequest;
import com.example.logisticprogram.dto.response.application.ApplicationResponse;
import com.example.logisticprogram.mapper.application.ApplicationMapper;
import com.example.logisticprogram.mapper.application.ApplicationMerger;
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
    private final ApplicationMerger applicationMerger;
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
    @Transactional
    public void editApplication(ApplicationAddRequest request) {
        var application = applicationRepository.getReferenceById(request.getId());
        applicationRepository.save(applicationMerger.merge(application, request)).getId();
    }
}
