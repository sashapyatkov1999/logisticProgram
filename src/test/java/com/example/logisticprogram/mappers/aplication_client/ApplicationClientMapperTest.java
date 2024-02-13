package com.example.logisticprogram.mappers.aplication_client;

import com.example.logisticprogram.dto.request.application_client.ApplicationClientAddRequest;
import com.example.logisticprogram.entity.ApplicationClient;
import com.example.logisticprogram.mapper.allpication_client.ApplicationClientMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ApplicationClientMapperTest {
    @Mock
    private ApplicationClientAddRequest applicationClientAddRequest;

    Long number = 0L;

    Long applicationId = 1L;
    Long clientId = 2L;
    String description = "";

    @Test
     void from() {

        //spy
        var source = spy(getApplicationClientAddRequest());
        var result = mapper().from(source);

        assertNull(result.getId());
        assertNull(result.getCreated());
        assertNull(result.getModified());
        assertEquals(applicationId, result.getApplication().getId());
        assertEquals(clientId, result.getClient().getId());
        assertEquals(description, result.getDescription());
        verify(source).getApplicationId();
        verify(source).getClientId();
        verify(source).getDescription();
        verifyNoMoreInteractions(source);
    }

    public  ApplicationClientMapper mapper(){
        return new ApplicationClientMapper();
    }
    private ApplicationClientAddRequest getApplicationClientAddRequest(){
        return new ApplicationClientAddRequest()
                .setApplicationId(applicationId)
                .setClientId(clientId)
                .setDescription(description);
    }
}
