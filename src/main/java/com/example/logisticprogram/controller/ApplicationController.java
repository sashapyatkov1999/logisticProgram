package com.example.logisticprogram.controller;

import com.example.logisticprogram.dto.request.application.ApplicationAddRequest;
import com.example.logisticprogram.dto.request.application.ApplicationNumberRequest;
import com.example.logisticprogram.dto.request.point.PointNumberRequest;
import com.example.logisticprogram.dto.response.application.ApplicationResponse;
import com.example.logisticprogram.dto.response.point.PointResponse;
import com.example.logisticprogram.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class ApplicationController {
    private final ApplicationService service;
    public static final String APPLICATION_GET_BY_NUMBER = "/api/v1/application/find-by-number";
    public static final String APPLICATION_DELETE = "/api/v1/application/delete";
    public static final String APPLICATION_ADD = "/api/v1/application/add";
    public static final String APPLICATION_GET_ALL = "/api/v1/application/get-all";
    public static final String APPLICATION_EDIT = "/api/v1/application/edit";
    public static final String POINT_GET = "/api/v1/point/get";
    public static final String POINT_DELETE = "/api/v1/point/delete";
    public static final String POINTS_GET_ALL = "/api/v1/points/get-all";
    public static final String POINT_GET_BY_APPLICATION = "/api/v1/point/get-by-application";

    @PostMapping(
            value = APPLICATION_GET_BY_NUMBER,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public ApplicationResponse findByNumber(@RequestBody ApplicationNumberRequest request) {
        return service.getApplication(request);
    }

    @PostMapping(
            value = APPLICATION_DELETE,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public void deleteApplication(@RequestBody ApplicationNumberRequest request) {
        service.deleteApplication(request);
    }

    @PostMapping(
            value = APPLICATION_ADD,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public ApplicationResponse addApplication(@RequestBody ApplicationAddRequest request) {
        return service.addApplication(request);
    }

    @PostMapping(
            value = APPLICATION_GET_ALL,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public List<ApplicationResponse> getAllApplications() {
        return service.getAllApplications();
    }

    @PostMapping(
            value = APPLICATION_EDIT,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public ApplicationResponse editApplication(@RequestBody ApplicationAddRequest request) {
        return service.editApplication(request);
    }

    @PostMapping(
            value = POINT_GET,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public PointResponse getPoint(@RequestBody PointNumberRequest request) {
        return service.getPoint(request);
    }

    @PostMapping(
            value = POINT_DELETE,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public void deletePoint(@RequestBody PointNumberRequest request) {
        service.deletePoint(request);
    }

    @PostMapping(
            value = POINTS_GET_ALL,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public List<PointResponse> getAllPoints() {
        return service.getAllPoints();
    }

    @PostMapping(
            value = POINT_GET_BY_APPLICATION,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public List<PointResponse> pointGetByApplication(@RequestBody String request) {
        return service.pointGetByApplication(request);
    }
}

