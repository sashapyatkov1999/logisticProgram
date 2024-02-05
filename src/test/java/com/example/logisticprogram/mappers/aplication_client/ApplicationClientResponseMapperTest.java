package com.example.logisticprogram.mappers.aplication_client;

import com.example.logisticprogram.dto.response.application.ApplicationResponse;
import com.example.logisticprogram.dto.response.application_client.ApplicationClientResponse;
import com.example.logisticprogram.dto.response.user.UserResponse;
import com.example.logisticprogram.entity.Application;
import com.example.logisticprogram.entity.ApplicationClient;
import com.example.logisticprogram.entity.User;
import com.example.logisticprogram.mapper.allpication_client.ApplicationClientResponseMapper;
import com.example.logisticprogram.mapper.application.ApplicationResponseMapper;
import com.example.logisticprogram.mapper.user.UserResponseMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ApplicationClientResponseMapperTest {
    @Mock
    private ApplicationResponseMapper applicationResponseMapper;

    @Mock
    private UserResponseMapper clientResponseMapper;

    @InjectMocks
    private ApplicationClientResponseMapper mapper;

    Long id = 1L;
    String description = "";
    LocalDateTime created = LocalDateTime.now();
    LocalDateTime modified = LocalDateTime.now();

    @Test
    void ApplicationClientResponseTest() {
        when(applicationResponseMapper.from(application())).thenReturn(applicationResponse());
        when(clientResponseMapper.from(client())).thenReturn(clientResponse());

        ApplicationClientResponse result = mapper.from(source());

        assertEquals(id, result.getId());
        assertEquals(applicationResponse(), result.getApplication());
        assertEquals(clientResponse(), result.getClient());
        assertEquals(description, result.getDescription());
        assertEquals(created, result.getCreated());
        assertEquals(modified, result.getModified());
    }
    ApplicationClient source(){
        ApplicationClient source = new ApplicationClient();
        return source.setId(id)
                .setApplication(application())
                .setClient(client())
                .setDescription(description)
                .setCreated(created)
                .setModified(modified);
    }
    Application application(){
        return new Application();
    }
    User client(){
         return new User();
    }
    ApplicationResponse applicationResponse(){
        return new ApplicationResponse();
    }
    UserResponse clientResponse(){
        return new UserResponse();
    }
}