package com.example.logisticprogram.mapper.application;

import com.example.logisticprogram.dto.request.application.ApplicationAddRequest;
import com.example.logisticprogram.entity.Application;
import com.example.logisticprogram.entity.Driver;
import com.example.logisticprogram.entity.User;
import com.example.logisticprogram.mapper.Merger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationMerger implements Merger<Application, ApplicationAddRequest> {
    @Override
    public Application merge(Application target, ApplicationAddRequest source) {
        return target
                .setManager(new User(source.getManagerId()))
                .setDriver(new Driver(source.getDriverId()))
                .setDescription(source.getDescription())
                .setName(source.getName());
    }
}
