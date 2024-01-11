package com.example.logisticprogram.mapper.application;

import com.example.logisticprogram.dto.response.application.ApplicationResponse;
import com.example.logisticprogram.dto.response.role.RoleResponse;
import com.example.logisticprogram.entity.Application;
import com.example.logisticprogram.mapper.Mapper;
import com.example.logisticprogram.mapper.driver.DriverResponseMapper;
import com.example.logisticprogram.mapper.user.UserResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationResponseMapper implements Mapper<ApplicationResponse, Application> {

    private final DriverResponseMapper driverResponseMapper;
    private final UserResponseMapper managerResponseMapper;
    @Override
    public ApplicationResponse from(Application source) {
        return new ApplicationResponse()
                .setId(source.getId())
                .setDriver(driverResponseMapper.from(source.getDriver()))
                .setManager(managerResponseMapper.from(source.getManager()))
                .setName(source.getName())
                .setDescription(source.getDescription())
                .setCreated(source.getCreated())
                .setModified(source.getModified());
    }
}
