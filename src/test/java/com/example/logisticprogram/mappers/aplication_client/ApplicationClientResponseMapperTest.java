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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

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


    @Test
    void from() {
        when(applicationResponseMapper.from(application())).thenReturn(applicationResponse());
        when(clientResponseMapper.from(client())).thenReturn(clientResponse());

        var source = spy(source());
        ApplicationClientResponse result = mapper.from(source);

        assertNull(result.getId());
        assertNull(result.getCreated());
        assertNull(result.getModified());
        assertEquals(applicationResponse(), result.getApplication());
        assertEquals(clientResponse(), result.getClient());
        assertEquals(description, result.getDescription());
        verify(source).getApplication();
        verify(source).getDescription();
        verify(source).getClient();

    }
    ApplicationClient source(){

        return new ApplicationClient()
                .setApplication(application())
                .setClient(client())
                .setDescription(description);
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