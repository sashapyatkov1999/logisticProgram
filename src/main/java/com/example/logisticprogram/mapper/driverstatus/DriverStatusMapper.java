package com.example.logisticprogram.mapper.driverstatus;

import com.example.logisticprogram.dto.request.driverstatus.DriverStatusAddRequest;
import com.example.logisticprogram.dto.request.userstatus.UserStatusAddRequest;
import com.example.logisticprogram.entity.DriverStatus;
import com.example.logisticprogram.entity.UserStatus;
import com.example.logisticprogram.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverStatusMapper implements Mapper<DriverStatus, DriverStatusAddRequest> {
    @Override
    public DriverStatus from(DriverStatusAddRequest source) {
        return new DriverStatus()
                .setName(source.getName())
                .setDescription(source.getDescription());
    }
}
