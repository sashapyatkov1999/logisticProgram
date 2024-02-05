package com.example.logisticprogram.mappers.aplication_client;

import com.example.logisticprogram.dto.request.application_client.ApplicationClientAddRequest;
import com.example.logisticprogram.entity.ApplicationClient;
import com.example.logisticprogram.mapper.allpication_client.ApplicationClientMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ApplicationClientMapperTest {
    @Mock
    private ApplicationClientAddRequest applicationClientAddRequest;

    Long applicationId = 1L;
    Long clientId = 2L;
    String description = "";

    @Test
     void ApplicationClientTest() {

        when(applicationClientAddRequest.getApplicationId()).thenReturn(applicationId);
        when(applicationClientAddRequest.getClientId()).thenReturn(clientId);
        when(applicationClientAddRequest.getDescription()).thenReturn(description);


        ApplicationClient result = mapper().from(applicationClientAddRequest);

        assertEquals(applicationId, result.getApplication().getId());
        assertEquals(clientId, result.getClient().getId());
        assertEquals(description, result.getDescription());
    }

    public  ApplicationClientMapper mapper(){
        return new ApplicationClientMapper();
    }
}
