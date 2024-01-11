package com.example.logisticprogram.mapper.application;

import com.example.logisticprogram.dto.request.application.ApplicationAddRequest;
import com.example.logisticprogram.entity.Application;
import com.example.logisticprogram.entity.Driver;
import com.example.logisticprogram.entity.Role;
import com.example.logisticprogram.entity.User;
import com.example.logisticprogram.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationMapper implements Mapper<Application, ApplicationAddRequest> {
    @Override
    public Application from(ApplicationAddRequest source) {
        return new Application()
                .setManager(new User(source.getManagerId()))
                .setDriver(new Driver(source.getDriverId()))
                .setName(source.getName())
                .setDescription(source.getDescription());
    }
}
