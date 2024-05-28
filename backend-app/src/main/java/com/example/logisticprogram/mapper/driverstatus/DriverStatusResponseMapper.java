package com.example.logisticprogram.mapper.driverstatus;

import com.example.logisticprogram.dto.response.driverstatus.DriverStatusResponse;
import com.example.logisticprogram.dto.response.userstatus.UserStatusResponse;
import com.example.logisticprogram.entity.DriverStatus;
import com.example.logisticprogram.entity.UserStatus;
import com.example.logisticprogram.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverStatusResponseMapper implements Mapper<DriverStatusResponse, DriverStatus> {
    @Override
    public DriverStatusResponse from(DriverStatus source) {
        return new DriverStatusResponse()
                .setId(source.getId())
                .setName(source.getName())
                .setDescription(source.getDescription())
                .setCreated(source.getCreated())
                .setModified(source.getModified());
    }
}
