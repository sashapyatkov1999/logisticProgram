package com.example.logisticprogram.mapper.allpication_client;

import com.example.logisticprogram.dto.request.application_client.ApplicationClientAddRequest;
import com.example.logisticprogram.entity.Application;
import com.example.logisticprogram.entity.ApplicationClient;
import com.example.logisticprogram.entity.User;
import com.example.logisticprogram.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationClientMapper implements Mapper<ApplicationClient, ApplicationClientAddRequest> {

    @Override
    public ApplicationClient from(ApplicationClientAddRequest source) {
        return new ApplicationClient()
                .setApplication(new Application(source.getApplicationId()))
                .setClient(new User(source.getClientId()))
                .setDescription(source.getDescription());
    }
}
