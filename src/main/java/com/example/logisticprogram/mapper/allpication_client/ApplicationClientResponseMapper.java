package com.example.logisticprogram.mapper.allpication_client;

import com.example.logisticprogram.dto.response.application.ApplicationResponse;
import com.example.logisticprogram.dto.response.application_client.ApplicationClientResponse;
import com.example.logisticprogram.entity.Application;
import com.example.logisticprogram.entity.ApplicationClient;
import com.example.logisticprogram.mapper.Mapper;
import com.example.logisticprogram.mapper.application.ApplicationResponseMapper;
import com.example.logisticprogram.mapper.user.UserResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationClientResponseMapper implements Mapper<ApplicationClientResponse, ApplicationClient> {
    private final ApplicationResponseMapper applicationResponseMapper;
    private final UserResponseMapper clientResponseMapper;

    @Override
    public ApplicationClientResponse from(ApplicationClient source) {
        return new ApplicationClientResponse()
                .setId(source.getId())
                .setApplication(applicationResponseMapper.from(source.getApplication()))
                .setClient(clientResponseMapper.from(source.getClient()))
                .setDescription(source.getDescription())
                .setCreated(source.getCreated())
                .setModified(source.getModified());
    }
}
