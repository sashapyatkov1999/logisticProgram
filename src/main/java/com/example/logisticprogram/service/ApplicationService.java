package com.example.logisticprogram.service;

import com.example.logisticprogram.dto.request.application.ApplicationAddRequest;
import com.example.logisticprogram.dto.request.application.ApplicationNumberRequest;
import com.example.logisticprogram.dto.request.point.PointAddRequest;
import com.example.logisticprogram.dto.request.point.PointNumberRequest;
import com.example.logisticprogram.dto.response.application.ApplicationResponse;
import com.example.logisticprogram.dto.response.point.PointResponse;
import com.example.logisticprogram.service.domain.ApplicationDomainService;
import com.example.logisticprogram.service.domain.PointDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationDomainService applicationDomainService;
    private final PointDomainService pointDomainService;

    public ApplicationResponse getApplication(ApplicationNumberRequest request) {
        return applicationDomainService.getApplication(request.getId());
    }

    public void deleteApplication(ApplicationNumberRequest request) {
        applicationDomainService.deleteApplication(request.getId());
    }

    public ApplicationResponse addApplication(ApplicationAddRequest request) {
        var id = applicationDomainService.addApplication(request);
        return applicationDomainService.getApplication(id);
    }

    public List<ApplicationResponse> getAllApplications() {
        return applicationDomainService.getAllApplications();
    }

    public ApplicationResponse editApplication(ApplicationAddRequest request) {
        applicationDomainService.editApplication(request);
        return applicationDomainService.getApplication(request.getId());
    }

    public PointResponse getPoint(PointNumberRequest request) {
        return pointDomainService.getPoint(request.getId());
    }

    public void deletePoint(PointNumberRequest request) {
        pointDomainService.deletePoint(request.getId());
    }

    public PointResponse addPoint(PointAddRequest request) {
        var id = pointDomainService.addPoint(request);
        return pointDomainService.getPoint(id);
    }

    public List<PointResponse> getAllPoints() {
        return pointDomainService.getAllPoints();
    }

    public void editPoint(PointAddRequest request) {
        pointDomainService.editPoint(request);
        pointDomainService.getPoint(request.getId());
    }

    public List<PointResponse> pointGetByApplication(String request) {
        return pointDomainService.getAllPoints()
                .stream()
                .filter(pointResponse ->
                        pointResponse.getField().toLowerCase().contains((request)))
                .toList();
    }
}
